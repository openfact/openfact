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
package org.openfact.representations.idm;

import java.util.ArrayList;
import java.util.List;

public class CustomerPartyRepresentation {

    protected String customerAssignedAccountId;
    protected List<String> additionalAccountId;
    protected PartyRepresentation party;

    public String getCustomerAssignedAccountId() {
        return customerAssignedAccountId;
    }

    public void setCustomerAssignedAccountId(String customerAssignedAccountId) {
        this.customerAssignedAccountId = customerAssignedAccountId;
    }

    public List<String> getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(List<String> additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    public PartyRepresentation getParty() {
        return party;
    }

    public void setParty(PartyRepresentation party) {
        this.party = party;
    }

}
