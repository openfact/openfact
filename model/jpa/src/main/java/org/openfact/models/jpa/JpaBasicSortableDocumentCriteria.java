package org.openfact.models.jpa;

import org.openfact.models.DocumentQuery;
import org.openfact.models.OrganizationModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class JpaBasicSortableDocumentCriteria<T> extends JpaSortableDocumentCriteria<T> {

    private String[] orderByAsc;
    private String[] orderByDesc;

    public JpaBasicSortableDocumentCriteria(EntityManager em, Class<T> tClass, OrganizationModel organization, DocumentQuery documentQuery, JpaDocumentCriteria jpaDocumentCriteria) {
        super(em, tClass, organization, documentQuery, jpaDocumentCriteria);
    }

    public void orderByAsc(String[] orderByAsc) {
        this.orderByAsc = orderByAsc;
    }

    public void orderByDesc(String[] orderByDesc) {
        this.orderByDesc = orderByDesc;
    }

    @Override
    public TypedQuery<T> buildTypedQuery() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        List<Order> orderList = new ArrayList<>();
        for (String order : orderByAsc) {
            orderList.add(cb.asc((root.get(order))));
        }
        for (String order : orderByDesc) {
            orderList.add(cb.desc((root.get(order))));
        }
        if (!orderList.isEmpty()) {
            cq.orderBy(orderList);
        }
        return em.createQuery(cq);
    }
}
