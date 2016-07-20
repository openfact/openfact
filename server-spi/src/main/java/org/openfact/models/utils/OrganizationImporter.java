package org.openfact.models.utils;

import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.OrganizationRepresentation;

/**
 * Helper interface used just because RealmManager is in repeid-services and not accessible for ImportUtils
 *
 */
public interface OrganizationImporter {

    OrganizationModel importOrganization(OrganizationRepresentation rep);
}
