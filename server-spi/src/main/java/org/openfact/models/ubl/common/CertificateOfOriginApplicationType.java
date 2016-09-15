package org.openfact.models.ubl.common;

import java.util.List;

public interface CertificateOfOriginApplicationType {

    ReferenceIDType getReferenceID();

    void setReferenceID(ReferenceIDType value);

    CertificateTypeType getCertificateType();

    void setCertificateType(CertificateTypeType value);

    ApplicationStatusCodeType getApplicationStatusCode();

    void setApplicationStatusCode(ApplicationStatusCodeType value);

    OriginalJobIDType getOriginalJobID();

    void setOriginalJobID(OriginalJobIDType value);

    PreviousJobIDType getPreviousJobID();

    void setPreviousJobID(PreviousJobIDType value);

    RemarksType getRemarks();

    void setRemarks(RemarksType value);

    ShipmentType getShipment();

    void setShipment(ShipmentType value);

    List<EndorserPartyType> getEndorserParty();

    void setEndorserParty(List<EndorserPartyType> endorserParty);

    PartyType getPreparationParty();

    void setPreparationParty(PartyType value);

    PartyType getIssuerParty();

    void setIssuerParty(PartyType value);

    CountryType getIssuingCountry();

    void setIssuingCountry(CountryType value);

    List<DocumentDistributionType> getDocumentDistribution();

    void setDocumentDistribution(List<DocumentDistributionType> documentDistribution);

    List<DocumentReferenceType> getSupportingDocumentReference();

    void setSupportingDocumentReference(List<DocumentReferenceType> supportingDocumentReference);

    List<SignatureType> getSignature();

    void setSignature(List<SignatureType> signature);

    String getId();

    void setId(String value);

}
