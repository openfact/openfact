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
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.cache.DebitNoteCache;
import org.openfact.models.ubl.provider.DebitNoteProvider;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class DebitNoteCacheSession implements DebitNoteCache {
    protected static final Logger logger = Logger.getLogger(DebitNoteCacheSession.class);
    protected DebitNoteCacheManager cache;
    protected OpenfactSession session;
    protected DebitNoteProvider delegate;
    protected boolean transactionActive;
    protected boolean setRollbackOnly;
    protected final long startupRevision;

    protected Set<String> invalidations = new HashSet<>();
    protected Set<String> organizationInvalidations = new HashSet<>();
    protected Map<String, DebitNoteModel> managedDebitNotes = new HashMap<>();

    public DebitNoteCacheSession(DebitNoteCacheManager cache, OpenfactSession session) {
        startupRevision = 0;
    }

    @Override
    public DebitNoteModel addDebitNote(OrganizationModel organization, String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DebitNoteModel getDebitNoteById(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DebitNoteModel getDebitNoteByID(OrganizationModel organization, String ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeDebitNote(OrganizationModel organization, DebitNoteModel debitNote) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> getDebitNotes(OrganizationModel organization, Integer firstResult,
            Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DebitNoteModel> searchForDebitNote(OrganizationModel organization, String filterText,
            Integer firstResult, Integer maxResults) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
            SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<DebitNoteModel> searchForDebitNote(OrganizationModel organization,
            SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDebitNotesCount(OrganizationModel organization) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public DebitNoteModel getLastDebitNote(OrganizationModel organization, int lenght, String mask) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void evict(OrganizationModel organization, DebitNoteModel debitNote) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    
}
