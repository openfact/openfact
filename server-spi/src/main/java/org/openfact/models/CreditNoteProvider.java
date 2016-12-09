/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models;

import org.openfact.models.enums.RequiredAction;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

import java.util.List;

public interface CreditNoteProvider extends Provider {

    CreditNoteModel addCreditNote(OrganizationModel organization, String ID);

    CreditNoteModel getCreditNoteById(OrganizationModel organization, String id);

    CreditNoteModel getCreditNoteByDocumentId(OrganizationModel organizationModel, String ID);

    void preRemove(OrganizationModel organization);

    boolean removeCreditNote(OrganizationModel organization, String id);

    boolean removeCreditNote(OrganizationModel organization, CreditNoteModel crebitNote);

    int getCreditNotesCount(OrganizationModel organization);

    List<CreditNoteModel> getCreditNotes(OrganizationModel organization);

    List<CreditNoteModel> getCreditNotes(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction);

    List<CreditNoteModel> getCreditNotes(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<CreditNoteModel> searchForCreditNote(OrganizationModel organization, String filterText);

    List<CreditNoteModel> searchForCreditNote(OrganizationModel organization, String filterText, Integer firstResult, Integer maxResults);

    SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);

    ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization);

    ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization, boolean asc);

    ScrollModel<CreditNoteModel> getCreditNotesScroll(OrganizationModel organization, boolean asc, int scrollSize);

    ScrollModel<List<CreditNoteModel>> getCreditNotesScroll(OrganizationModel organization, int scrollSize, String... requiredAction);
}
