package org.openfact.models.cache.infinispan.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class OrganizationListQuery extends AbstractRevisioned implements OrganizationQuery {
    private final Set<String> organizations;

    public OrganizationListQuery(Long revision, String id, String organization) {
        super(revision, id);
        organizations = new HashSet<>();
        organizations.add(organization);
    }

    public OrganizationListQuery(Long revision, String id, Set<String> organizations) {
        super(revision, id);
        this.organizations = organizations;
    }

    @Override
    public Set<String> getOrganizations() {
        return organizations;
    }
}