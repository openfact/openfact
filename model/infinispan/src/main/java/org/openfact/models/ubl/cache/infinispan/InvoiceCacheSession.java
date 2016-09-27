/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.models.ubl.cache.infinispan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.cache.InvoiceCache;
import org.openfact.models.ubl.provider.InvoiceProvider;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class InvoiceCacheSession implements InvoiceCache {
    protected static final Logger logger = Logger.getLogger(InvoiceCacheSession.class);
    protected InvoiceCacheManager cache;
    protected OpenfactSession session;
    protected InvoiceProvider delegate;
    protected boolean transactionActive;
    protected boolean setRollbackOnly;
    protected final long startupRevision;

    protected Set<String> invalidations = new HashSet<>();
    protected Set<String> organizationInvalidations = new HashSet<>();
    protected Map<String, InvoiceModel> managedInvoices = new HashMap<>();

    public InvoiceCacheSession(InvoiceCacheManager cache, OpenfactSession session) {
        startupRevision = 0;
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization, String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InvoiceModel getInvoiceById(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InvoiceModel getInvoiceByID(OrganizationModel organization, String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<InvoiceModel> searchForInvoice(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getInvoicesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public void evict(OrganizationModel organization, InvoiceModel invoice) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public InvoiceModel getLastInvoice(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

}
