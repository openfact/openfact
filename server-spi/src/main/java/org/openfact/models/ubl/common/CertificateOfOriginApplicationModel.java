package org.openfact.models.ubl.common;

import java.util.List;

public interface CertificateOfOriginApplicationModel {

    ReferenceIDModel getReferenceID();

    void setReferenceID(ReferenceIDModel value);

    CertificateModelModel getCertificateModel();

    void setCertificateModel(CertificateModelModel value);

    ApplicationStatusCodeModel getApplicationStatusCode();

    void setApplicationStatusCode(ApplicationStatusCodeModel value);

    OriginalJobIDModel getOriginalJobID();

    void setOriginalJobID(OriginalJobIDModel value);

    PreviousJobIDModel getPreviousJobID();

    void setPreviousJobID(PreviousJobIDModel value);

    RemarksModel getRemarks();

    void setRemarks(RemarksModel value);

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

    void setId(String value);

}
