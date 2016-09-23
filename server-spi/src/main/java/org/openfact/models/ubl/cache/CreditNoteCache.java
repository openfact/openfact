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

package org.openfact.models.ubl.cache;

import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.provider.CreditNoteProvider;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public interface CreditNoteCache extends CreditNoteProvider {
    /**
     * Evict user from cache.
     *
     * @param user
     */
    void evict(OrganizationModel organization, CreditNoteModel creditNote);
    void clear();
}
