package org.openfact.models.ubl.provider.pe;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.PerceptionModel;
import org.openfact.provider.Provider;

public interface PerceptionProvider extends Provider {
	
	PerceptionModel addPerception(OrganizationModel organization, String ID);

	PerceptionModel getPerceptionById(OrganizationModel organization, String id);

	PerceptionModel getPerceptionByID(OrganizationModel organizationModel, String ID);

	boolean removePerception(OrganizationModel organization, String id);

	boolean removePerception(OrganizationModel organization, PerceptionModel perception);

	List<PerceptionModel> getPerceptions(OrganizationModel organization);

	List<PerceptionModel> getPerceptions(OrganizationModel organization, List<RequeridActionDocument> requeridAction,
			boolean intoRequeridAction);

	List<PerceptionModel> getPerceptions(OrganizationModel organization, Integer firstResult, Integer maxResults);

	List<PerceptionModel> searchForPerception(OrganizationModel organization, String filterText);

	List<PerceptionModel> searchForPerception(OrganizationModel organization, String filterText, Integer firstResult,
			Integer maxResults);

	SearchResultsModel<PerceptionModel> searchForPerception(OrganizationModel organization,
			SearchCriteriaModel criteria);

	SearchResultsModel<PerceptionModel> searchForPerception(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText);

	int getPerceptionsCount(OrganizationModel organization);

	PerceptionModel getLastPerception(OrganizationModel organization, int lenght, String mask);
}
