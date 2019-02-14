package com.fork.cash.services.xxservice;

import com.fork.cash.services.entity.ProjectionSummary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProjectedCashImpl  implements ProjectedCash {

    @PersistenceContext
    private EntityManager em;

    public List<ProjectionSummary> findProjectedCash() {

//        TypedQuery query = em.createQuery("select transaction_summary_id, account_symbol from cru.get_projected_cash(?1, ?2) ", Cash.class);

        TypedQuery query = em.createQuery("select * from cru.daily_transaction_summary" , ProjectionSummary.class);
//        query.setParameter(1, "1/25/2019");
//        query.setParameter(2, "30");
    return  null;
//        return   query.getResultList();
    }
}
