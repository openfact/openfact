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

public interface InvoiceProvider extends Provider {

    InvoiceModel addInvoice(OrganizationModel organization, String ID);

    InvoiceModel getInvoiceById(OrganizationModel organization, String id);

    InvoiceModel getInvoiceByID(OrganizationModel organization, String ID);

    void preRemove(OrganizationModel organization);

    boolean removeInvoice(OrganizationModel organization, String id);

    boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice);

    int getInvoicesCount(OrganizationModel organization);

    List<InvoiceModel> getInvoices(OrganizationModel organization);

    List<InvoiceModel> getInvoices(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction);

    List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult, Integer maxResults);

    List<InvoiceModel> searchForInvoice(OrganizationModel organization, String filterText);

    List<InvoiceModel> searchForInvoice(OrganizationModel organization, String filterText, Integer firstResult, Integer maxResults);

    SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria);

    SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText);

    ScrollModel<InvoiceModel> getInvoicesScroll(OrganizationModel organization);

    ScrollModel<InvoiceModel> getInvoicesScroll(OrganizationModel organization, boolean asc);

    ScrollModel<InvoiceModel> getInvoicesScroll(OrganizationModel organization, boolean asc, int scrollSize);

    ScrollModel<List<InvoiceModel>> getInvoicesScroll(OrganizationModel organization, int scrollSize, String... requiredAction);

}
