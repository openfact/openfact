package org.openfact.models.ubl.provider.pe;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.SummaryDocumentsModel;
import org.openfact.provider.Provider;

public interface SummaryDocumentsProvider extends Provider {
	SummaryDocumentsModel addSummaryDocuments(OrganizationModel organization, String ID);

	SummaryDocumentsModel getSummaryDocumentsById(OrganizationModel organization, String id);

	SummaryDocumentsModel getSummaryDocumentsByID(OrganizationModel organizationModel, String ID);

	boolean removeSummaryDocuments(OrganizationModel organization, String id);

	boolean removeSummaryDocuments(OrganizationModel organization, SummaryDocumentsModel summaryDocuments);

	List<SummaryDocumentsModel> getSummaryDocumentss(OrganizationModel organization);

	List<SummaryDocumentsModel> getSummaryDocumentss(OrganizationModel organization, List<RequeridActionDocument> requeridAction,
			boolean intoRequeridAction);

	List<SummaryDocumentsModel> getSummaryDocumentss(OrganizationModel organization, Integer firstResult, Integer maxResults);

	List<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization, String filterText);

	List<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization, String filterText, Integer firstResult,
			Integer maxResults);

	SearchResultsModel<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria);

	SearchResultsModel<SummaryDocumentsModel> searchForSummaryDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText);

	int getSummaryDocumentssCount(OrganizationModel organization);

	SummaryDocumentsModel getLastSummaryDocuments(OrganizationModel organization, int lenght, String mask);
}
