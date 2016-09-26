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
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.cache.CreditNoteCache;
import org.openfact.models.ubl.provider.CreditNoteProvider;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class CreditNoteCacheSession implements CreditNoteCache {
    protected static final Logger logger = Logger.getLogger(CreditNoteCacheSession.class);
    protected CreditNoteCacheManager cache;
    protected OpenfactSession session;
    protected CreditNoteProvider delegate;
    protected boolean transactionActive;
    protected boolean setRollbackOnly;
    protected final long startupRevision;

    protected Set<String> invalidations = new HashSet<>();
    protected Set<String> organizationInvalidations = new HashSet<>();
    protected Map<String, CreditNoteModel> managedCreditNotes = new HashMap<>();

    public CreditNoteCacheSession(CreditNoteCacheManager cache, OpenfactSession session) {
        startupRevision = 0;
    }

    @Override
    public CreditNoteModel addCreditNote(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CreditNoteModel addCreditNote(OrganizationModel organization, String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CreditNoteModel getCreditNoteById(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CreditNoteModel getCreditNoteByID(OrganizationModel organizationModel, String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeCreditNote(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel crebitNote) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditNoteModel> getCreditNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(String filterText, OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditNoteModel> searchForCreditNote(String filterText, OrganizationModel organization,
            Integer firstResult, Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<CreditNoteModel> searchForCreditNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCreditNotesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void evict(OrganizationModel organization, CreditNoteModel creditNote) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    

}
