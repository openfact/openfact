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

public interface DebitNoteProvider extends Provider {

    DebitNoteModel addDebitNote(OrganizationModel organization, String ID);

    DebitNoteModel getDebitNoteById(OrganizationModel organization, String id);

    DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID);

    void preRemove(OrganizationModel organization);

    boolean removeDebitNote(OrganizationModel organization, String id);

    boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote);

    int getDebitNotesCount(OrganizationModel organization);

    List<DebitNoteModel> getDebitNotes(OrganizationModel organization);

    List<DebitNoteModel> getDebitNotes(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction);

    List<DebitNoteModel> getDebitNotes(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText);

    List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText, Integer firstResult, Integer maxResults);

    SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);

    ScrollModel<DebitNoteModel> getDebitNotesScroll(OrganizationModel organization);

    ScrollModel<DebitNoteModel> getDebitNotesScroll(OrganizationModel organization, boolean asc);

    ScrollModel<DebitNoteModel> getDebitNotesScroll(OrganizationModel organization, boolean asc, int scrollSize);

    ScrollModel<List<DebitNoteModel>> getDebitNotesScroll(OrganizationModel organization, int scrollSize, String... requiredAction);

}
