package org.openfact.models.ubl.provider.pe;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.pe.VoidedDocumentsModel;
import org.openfact.provider.Provider;

public interface VoidedDocumentsProvider extends Provider {
	VoidedDocumentsModel addVoidedDocuments(OrganizationModel organization, String ID);

	VoidedDocumentsModel getVoidedDocumentsById(OrganizationModel organization, String id);

	VoidedDocumentsModel getVoidedDocumentsByID(OrganizationModel organizationModel, String ID);

	boolean removeVoidedDocuments(OrganizationModel organization, String id);

	boolean removeVoidedDocuments(OrganizationModel organization, VoidedDocumentsModel voidedDocuments);

	List<VoidedDocumentsModel> getVoidedDocumentss(OrganizationModel organization);

	List<VoidedDocumentsModel> getVoidedDocumentss(OrganizationModel organization, List<RequeridActionDocument> requeridAction,
			boolean intoRequeridAction);

	List<VoidedDocumentsModel> getVoidedDocumentss(OrganizationModel organization, Integer firstResult, Integer maxResults);

	List<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization, String filterText);

	List<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization, String filterText, Integer firstResult,
			Integer maxResults);

	SearchResultsModel<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria);

	SearchResultsModel<VoidedDocumentsModel> searchForVoidedDocuments(OrganizationModel organization,
			SearchCriteriaModel criteria, String filterText);

	int getVoidedDocumentssCount(OrganizationModel organization);

	VoidedDocumentsModel getLastVoidedDocuments(OrganizationModel organization, int lenght, String mask);
}
