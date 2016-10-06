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
