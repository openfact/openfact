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
package org.openfact.models.ubl.common;

import java.util.List;

public interface PartyModel {

    boolean getMarkCareIndicator();

    void setMarkCareIndicator(boolean value);

    boolean getMarkAttentionIndicator();

    void setMarkAttentionIndicator(boolean value);

    String getWebsiteURI();

    void setWebsiteURI(String value);

    String getLogoReferenceID();

    void setLogoReferenceID(String value);

    String getEndpointID();

    void setEndpointID(String value);

    List<String> getPartyIdentification();

    void setPartyIdentification(List<String> partyIdentification);

    List<String> getPartyName();

    void setPartyName(List<String> partyName);

    LanguageModel getLanguage();

    void setLanguage(LanguageModel value);

    AddressModel getPostalAddress();

    void setPostalAddress(AddressModel value);

    LocationCommAggModel getPhysicalLocation();

    void setPhysicalLocation(LocationCommAggModel value);

    List<PartyTaxSchemeModel> getPartyTaxScheme();

    void setPartyTaxScheme(List<PartyTaxSchemeModel> partyTaxScheme);

    List<PartyLegalModel> getPartyLegalEntity();

    void setPartyLegalEntity(List<PartyLegalModel> partyLegalEntity);

    ContactModel getContact();

    void setContact(ContactModel value);

    PersonModel getPerson();

    void setPerson(PersonModel value);

    PartyModel getAgentParty();

    void setAgentParty(PartyModel value);

    String getId();


    /**
     * */
    PartyLegalModel addPartyLegalEntity();

}
