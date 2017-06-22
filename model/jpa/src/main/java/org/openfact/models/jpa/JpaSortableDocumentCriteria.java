package org.openfact.models.jpa;

import org.openfact.models.DocumentModel;
import org.openfact.models.DocumentQueryModel;
import org.openfact.models.OrganizationModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JpaSortableDocumentCriteria<T> extends JpaDocumentCriteria<T> {

    private List<String> orderByAsc;
    private List<String> orderByDesc;

    public JpaSortableDocumentCriteria(EntityManager em, Class<T> tClass, OrganizationModel organization, DocumentQueryModel documentQuery) {
        super(em, tClass, organization, documentQuery);
    }

    public void orderByAsc(String... orderByAsc) {
        if (orderByAsc != null) {
            if (Arrays.asList(DocumentModel.ORDER_BY_FIELDS).containsAll(Arrays.asList(orderByAsc))) {
                this.orderByAsc = Arrays.asList(orderByAsc);
            } else {
                throw new IllegalStateException("Order by not supported on some fields");
            }
        }
    }

    public void orderByDesc(String... orderByDesc) {
        if (orderByDesc != null) {
            if (Arrays.asList(DocumentModel.ORDER_BY_FIELDS).containsAll(Arrays.asList(orderByDesc))) {
                this.orderByDesc = Arrays.asList(orderByDesc);
            } else {
                throw new IllegalStateException("Order by not supported on some fields");
            }
        }
    }

    @Override
    public TypedQuery<T> buildTypedQuery() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        List<Order> orderList = new ArrayList<>();
        if (orderByAsc != null) {
            for (String order : orderByAsc) {
                orderList.add(cb.asc((root.get(order))));
            }
        }
        if (orderByDesc != null) {
            for (String order : orderByDesc) {
                orderList.add(cb.desc((root.get(order))));
            }
        }

        if (!orderList.isEmpty()) {
            cq.orderBy(orderList);
        }
        return em.createQuery(cq);
    }

}
