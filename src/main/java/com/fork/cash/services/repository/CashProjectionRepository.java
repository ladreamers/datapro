package com.fork.cash.services.repository;

import com.fork.cash.services.entity.ProjectionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CashProjectionRepository extends JpaRepository<ProjectionSummary, Long> {

    @Query(value = "select distinct * from cru.trans_summary where as_of_dt=?1 " +
            "and projection_dt < date(?1)+ INTERVAL '1 DAY' * ?2 " +
            "order by account_symbol, currency_cd, display_order, projection_dt", nativeQuery = true)
    Collection<ProjectionSummary> getProjectionAsOf(Date as_of_dt, Integer days_out);

//    @Query(value = "with query as (" +
//            "select *, " +
//            "rank() over(partition by projection_level_identifier order by projection_level_identifier, projection_dt) as ranking " +
//            "from cru.trans_summary where as_of_dt='1/30/2019' )" +
//            "select * from query where ranking <= ?1 " +
//            "order by account_symbol, currency_cd, display_order, projection_dt", nativeQuery = true)
//    Collection<ProjectionSummary> getProjectionTest(Integer rank);





}





