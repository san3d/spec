package com.makarski.spec.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import com.makarski.spec.dataaccess.PartDao;
import com.makarski.spec.dataaccess.filters.PartFilter;
import com.makarski.spec.datamodel.Part;

@Repository
public class PartDaoImpl extends AbstractDaoImpl<Part, Long> implements PartDao {

    protected PartDaoImpl() {
        super(Part.class);
    }

    @Override
    public Long count(PartFilter filter) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Part> from = cq.from(Part.class);
        cq.select(cb.count(from));
        TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Override
    public List<Part> find(PartFilter filter) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Part> cq = cb.createQuery(Part.class);
        Root<Part> from = cq.from(Part.class);
        cq.select(from);
        // set sort params

        if (filter.getSortProperty() != null) {
            cq.orderBy(new OrderImpl(from.get(filter.getSortProperty()), filter.isSortOrder()));
        }

        TypedQuery<Part> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
    }

}
