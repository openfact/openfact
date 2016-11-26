package org.openfact.ubl;

import java.util.List;

import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ScrollModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface SendEventProvider extends Provider {

    SendEventModel addSendEvent(OrganizationModel organization, SendResultType type, InvoiceModel invoice);

    SendEventModel addSendEvent(OrganizationModel organization, SendResultType type,
            CreditNoteModel creditNote);

    SendEventModel addSendEvent(OrganizationModel organization, SendResultType type,
            DebitNoteModel debitNote);

    SendEventModel getSendEventById(OrganizationModel organization, String id);

    boolean removeSendEvent(OrganizationModel organization, String id);

    boolean removeSendEvent(OrganizationModel organization, SendEventModel invoice);

    int getSendEventsCount(OrganizationModel organization);

    List<SendEventModel> getSendEvents(OrganizationModel organization);

    List<SendEventModel> getSendEvents(OrganizationModel organization, Integer firstResult,
            Integer maxResults);

    SearchResultsModel<SendEventModel> searchForSendEvent(OrganizationModel organization,
            SearchCriteriaModel criteria);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization, boolean asc);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization, boolean asc,
            int scrollSize);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization, boolean asc,
            int scrollSize, int fetchSize);

}
