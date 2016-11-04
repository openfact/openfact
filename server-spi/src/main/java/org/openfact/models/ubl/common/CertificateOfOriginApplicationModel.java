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

public interface CertificateOfOriginApplicationModel {

    String getReferenceID();

    void setReferenceID(String value);

    String getCertificateModel();

    void setCertificateModel(String value);

    String getApplicationStatusCode();

    void setApplicationStatusCode(String value);

    String getOriginalJobID();

    void setOriginalJobID(String value);

    String getPreviousJobID();

    void setPreviousJobID(String value);

    String getRemarks();

    void setRemarks(String value);

    ShipmentModel getShipment();

    void setShipment(ShipmentModel value);

    List<EndorserPartyModel> getEndorserParty();

    void setEndorserParty(List<EndorserPartyModel> endorserParty);

    PartyModel getPreparationParty();

    void setPreparationParty(PartyModel value);

    PartyModel getIssuerParty();

    void setIssuerParty(PartyModel value);

    CountryModel getIssuingCountry();

    void setIssuingCountry(CountryModel value);

    List<DocumentDistributionModel> getDocumentDistribution();

    void setDocumentDistribution(List<DocumentDistributionModel> documentDistribution);

    List<DocumentReferenceModel> getSupportingDocumentReference();

    void setSupportingDocumentReference(List<DocumentReferenceModel> supportingDocumentReference);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    String getId();


}
