package org.openfact.models.cache.infinispan.stream;

import java.io.Serializable;
import java.util.Map;
import java.util.function.Predicate;

import org.openfact.models.cache.infinispan.entities.InOrganization;
import org.openfact.models.cache.infinispan.entities.Revisioned;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class InOrganizationPredicate implements Predicate<Map.Entry<String, Revisioned>>, Serializable {
    private String organization;

    public static InOrganizationPredicate create() {
        return new InOrganizationPredicate();
    }

    public InOrganizationPredicate organization(String id) {
        organization = id;
        return this;
    }

    @Override
    public boolean test(Map.Entry<String, Revisioned> entry) {
        Object value = entry.getValue();
        if (value == null)
            return false;
        if (!(value instanceof InOrganization))
            return false;

        return organization.equals(((InOrganization) value).getOrganization());
    }
}
