package com.fork.cash.services.controller;

import com.fork.cash.services.entity.FeedType;
import com.fork.cash.services.entity.ProjSum;
import com.fork.cash.services.entity.ProjectionSummary;
import com.fork.cash.services.repository.CashProjectionRepository;
import com.fork.cash.services.entity.ProjectionTransaction;
import com.fork.cash.services.repository.FeedTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CashController  {

	@Autowired
	private CashProjectionRepository cashProjectinRepository;

	@Autowired
	private FeedTypeRepo feedTypeRepo;

	@Autowired
	private EntityManager entityManager;

	public Date StringToDate(String s){
		Date result = null;
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			result  = dateFormat.parse(s);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return result ;
	}


	@RequestMapping("/feedtypes")
	public Collection<FeedType> findProjectedLevel(){
		Collection<FeedType> projectionList =feedTypeRepo.getProjectionLevels();
		return projectionList;
	}





	@RequestMapping("/projections")
	public List<Results> findProjectedTest(){
		System.out.println("Hitting Test.");
		Collection<ProjectionSummary> projectionList = this.cashProjectinRepository.getProjectionAsOf( StringToDate("20190130"), 5);

//		boolean firstIterationFlag = true ;
		List<String> CalendarDays = new ArrayList<>();
		Map<Integer, ProjSum> dictionary = new HashMap<>();

		for (ProjectionSummary element : projectionList) {

			Integer imyKey = element.hashCode();
			ProjSum projection = new ProjSum();

					System.out.println(
						 imyKey
							+ " -- "+ element.getAccount_symbol()
							+ " -- "+ element.getProjection_dt()
							+ " -- "+ element.getProjection_level_identifier()
							+ " -- "+ element.getAmt_qc()
					);
			projection.setAccount_nm(element.getAccount_nm());
			projection.setAccount_symbol(element.getAccount_symbol());
			projection.setAs_of_dt(element.getAs_of_dt());
			projection.setProjection_level_identifier(element.getProjection_level_identifier());
			projection.setLevel1_nm(element.getLevel1_nm());
			projection.setLevel2_nm(element.getLevel2_nm());
			projection.setLevel3_nm(element.getLevel3_nm());
			projection.setCurrency_cd(element.getCurrency_cd());
			projection.setNsp_account_id(element.getNsp_account_id());
			projection.setDisplay_order(element.getDisplay_order());
			projection.setLevel1_cd(element.getLevel1_cd());
			projection.setLevel2_cd(element.getLevel2_cd());
			projection.setLevel3_cd(element.getLevel3_cd());
			projection.setPortfolio_currency_cd(element.getPortfolio_currency_cd());
			projection.setProjection_level_id(element.getProjection_level_id());
			projection.setProjections(getDetails(imyKey, projectionList));

			if (!dictionary.containsKey(imyKey))
				dictionary.put(imyKey, projection);
			else
				dictionary.computeIfPresent(imyKey, (k, v) -> projection);

//			if (firstIterationFlag == true)
//				CalendarDays.add(element.getProjection_dt());
//
//			firstIterationFlag = false;
		}

		List<ProjSum> sortedData = dictionary.values().stream()
				.sorted(Comparator.comparing(ProjSum::getAccount_symbol)
						.thenComparing(ProjSum::getDisplay_order)
						.thenComparing(ProjSum::getCurrency_cd))
				.collect(Collectors.toList());



//		List<ProjSum> resultData = dictionary.values().stream()
//				.collect(Collectors.toList());

//		resultData.sort(ProjSum ps1, ProjSum ps2)-> ps1.getDisplay_order()-ps2.getDisplay_order());

		Results results = new Results();
		results.setDates(CalendarDays);
		results.setData(sortedData);

		List<Results> resultsList = new ArrayList<>();
		resultsList.add(results);

		return resultsList;
	}

	private Map<Integer,ProjectionSummary> recurseThroughList(Collection<ProjectionSummary> projectionCollection) {

		if (projectionCollection  != null) {
			List<ProjectionTransaction> list = new ArrayList<>();

			for (ProjectionSummary detail : projectionCollection) {
				ProjectionTransaction pt = new ProjectionTransaction();
				pt.setAmt_pc(detail.getAmt_pc());
				pt.setAmt_qc(detail.getAmt_qc());
				pt.setAmt_usd(detail.getAmt_usd());
				pt.setAmount(detail.getAmt_pc());
				pt.setProjection_dt(detail.getProjection_dt());
				pt.setTransaction_summary_id(detail.getTransaction_summary_id());
				list.add(pt);
				recurseThroughList(projectionCollection);
			}
		}

		return null;
	}


	@RequestMapping(value = "/projections/{as_of_dt}/{days_out}", method=GET)
	@ResponseBody
	public List<Results> findProjectedCash(
		@PathVariable String as_of_dt,
		@PathVariable Integer days_out) {
		System.out.println("On Projected method.");

		Collection<ProjectionSummary> projectionSummary = this.cashProjectinRepository.getProjectionAsOf( StringToDate(as_of_dt), days_out);

		List<String> CalendarDays = new ArrayList<>();
		Map<Integer, ProjSum> dictionary = new HashMap<>();

		boolean firstIterationFlag = true ;

		for (ProjectionSummary element : projectionSummary) {

			Integer imyKey = element.hashCode();
			ProjSum projection = new ProjSum();

			projection.setAccount_nm(element.getAccount_nm());
			projection.setAccount_symbol(element.getAccount_symbol());
			projection.setAs_of_dt(element.getAs_of_dt());
			projection.setProjection_level_identifier(element.getProjection_level_identifier());
			projection.setLevel1_nm(element.getLevel1_nm());
			projection.setLevel2_nm(element.getLevel2_nm());
			projection.setLevel3_nm(element.getLevel3_nm());
			projection.setCurrency_cd(element.getCurrency_cd());
			projection.setNsp_account_id(element.getNsp_account_id());
			projection.setDisplay_order(element.getDisplay_order());
			projection.setLevel1_cd(element.getLevel1_cd());
			projection.setLevel2_cd(element.getLevel2_cd());
			projection.setLevel3_cd(element.getLevel3_cd());
			projection.setPortfolio_currency_cd(element.getPortfolio_currency_cd());
			projection.setProjection_level_id(element.getProjection_level_id());

			List<ProjectionTransaction> list = new ArrayList<>();
			for (ProjectionSummary detail : projectionSummary) {
				Integer imyKeyDetail = detail.hashCode();
				if ( imyKey.equals(imyKeyDetail) ) {
					System.out.println(
							 "Type&Curr --> "+ imyKey
							+ " --> "+ imyKeyDetail
							+ " |--> "+ detail.getAccount_symbol()
							+ " --> "+ detail.getCurrency_cd()
							+ " --> "+ detail.getProjection_level_identifier()
							+ " --> "+ detail.getProjection_dt()
							+ " --> "+ detail.getAmt_qc()
					);
					ProjectionTransaction pt = new ProjectionTransaction();
					pt.setAmt_pc(detail.getAmt_pc());
					pt.setAmt_qc(detail.getAmt_qc());
					pt.setAmt_usd(detail.getAmt_usd());
					pt.setAmount(detail.getAmt_pc());
					pt.setProjection_dt(detail.getProjection_dt());
					pt.setTransaction_summary_id(detail.getTransaction_summary_id());
					list.add(pt);

					if (firstIterationFlag == true)
						CalendarDays.add(detail.getProjection_dt());
				}

			}

			projection.setProjections(list);

			if (!dictionary.containsKey(imyKey))
				dictionary.put(imyKey, projection);
			else
				dictionary.computeIfPresent(imyKey, (k, v) -> projection);

			firstIterationFlag = false;
		}


		//Convert to list and set the order for the data by account, then display order, then currency:
		List<ProjSum> sortedData = dictionary.values().stream()
				.sorted(Comparator.comparing(ProjSum::getAccount_symbol)
						.thenComparing(ProjSum::getDisplay_order)
						.thenComparing(ProjSum::getCurrency_cd))
				.collect(Collectors.toList());

		Results results = new Results();
		results.setDates(CalendarDays);
		results.setData(sortedData);

		List<Results> resultsList = new ArrayList<>();
		resultsList.add(results);

		return resultsList;
	}

	private List<ProjectionTransaction> getDetails(Integer imyKey, Collection<ProjectionSummary> projectionSummary){

		List<ProjectionTransaction> list = new ArrayList<>();

		for (ProjectionSummary detail : projectionSummary) {

			Integer imyKeyDetail = detail.hashCode();

			if ( imyKey.equals(imyKeyDetail) ) {
				ProjectionTransaction pt = new ProjectionTransaction();
				pt.setAmt_pc(detail.getAmt_pc());
				pt.setAmt_qc(detail.getAmt_qc());
				pt.setAmt_usd(detail.getAmt_usd());
				pt.setAmount(detail.getAmt_pc());
				pt.setProjection_dt(detail.getProjection_dt());
				pt.setTransaction_summary_id(detail.getTransaction_summary_id());
				list.add(pt);
//				if (i==0)
//					CalendarDays.add(detail.getProjection_dt());
			}

		}

		return list;

	}


	class Results{
		List<String> dates;
		List<ProjSum> data;

		public List<String> getDates() {
			return dates;
		}

		public void setDates(List<String> dates) {
			this.dates = dates;
		}

		public List<ProjSum> getData() {
			return data;
		}

		public void setData(List<ProjSum> data) {
			this.data = data;
		}
	}



}







