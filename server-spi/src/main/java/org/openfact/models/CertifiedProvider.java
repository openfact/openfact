package org.openfact.models;

import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public interface CertifiedProvider extends Provider {

	CertifiedModel addCertified(OrganizationModel organization, String alias, FileInputStream certificate,
			String password, LocalDate validity);

	CertifiedModel getCertifiedById(String id, OrganizationModel organization);

	CertifiedModel getCertifiedByAliasAndValidity(String alias, LocalDate validity, OrganizationModel organization);

	boolean removeCertified(OrganizationModel organization, CertifiedModel certified);

	CertifiedModel getCertifiedEnabled(OrganizationModel organization);

	List<CertifiedModel> getCertifieds(OrganizationModel organization, Integer firstResult, Integer maxResults);

	List<CertifiedModel> searchForCertified(String filterText, OrganizationModel organization, Integer firstResult,
			Integer maxResults);

	List<CertifiedModel> searchForCertifiedByAttributes(Map<String, String> attributes, OrganizationModel organization);

	List<CertifiedModel> searchForCertifiedByAttributes(Map<String, String> attributes, OrganizationModel organization,
			Integer firstResult, Integer maxResults);

	SearchResultsModel<CertifiedModel> search(OrganizationModel organization, SearchCriteriaModel criteria);

	SearchResultsModel<CertifiedModel> search(OrganizationModel organization, SearchCriteriaModel criteria,
			String filterText);

}
