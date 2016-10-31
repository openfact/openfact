package org.openfact.models.ubl.provider.pe;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.RetentionModel;
import org.openfact.provider.Provider;

public interface RetentionProvider extends Provider {
	RetentionModel addRetention(OrganizationModel organization, String ID);

	RetentionModel getRetentionById(OrganizationModel organization, String id);

	RetentionModel getRetentionByID(OrganizationModel organizationModel, String ID);

	boolean removeRetention(OrganizationModel organization, String id);

	boolean removeRetention(OrganizationModel organization, RetentionModel retention);

	List<RetentionModel> getRetentions(OrganizationModel organization);

	List<RetentionModel> getRetentions(OrganizationModel organization, List<RequeridActionDocument> requeridAction,
			boolean intoRequeridAction);

	List<RetentionModel> getRetentions(OrganizationModel organization, Integer firstResult, Integer maxResults);

	List<RetentionModel> searchForRetention(OrganizationModel organization, String filterText);

	List<RetentionModel> searchForRetention(OrganizationModel organization, String filterText, Integer firstResult,
			Integer maxResults);

	SearchResultsModel<RetentionModel> searchForRetention(OrganizationModel organization,
			SearchCriteriaModel criteria);

	SearchResultsModel<RetentionModel> searchForRetention(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText);

	int getRetentionsCount(OrganizationModel organization);

	RetentionModel getLastRetention(OrganizationModel organization, int lenght, String mask);
}
