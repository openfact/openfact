package org.openfact.models.ubl.common;

import java.util.List;

public interface SummaryDocumentsLineType {

    LineIDType getLineID();

    void setLineID(LineIDType value);

    DocumentTypeCodeType getDocumentTypeCode();

    void setDocumentTypeCode(DocumentTypeCodeType value);

    IdentifierType getDocumentSerialID();

    void setDocumentSerialID(IdentifierType value);

    IdentifierType getStartDocumentNumberID();

    void setStartDocumentNumberID(IdentifierType value);

    IdentifierType getEndDocumentNumberID();

    void setEndDocumentNumberID(IdentifierType value);

    AmountTypeCommBas getTotalAmount();

    void setTotalAmount(AmountTypeCommBas value);

    List<PaymentType> getBillingPayment();

    void setBillingPayment(List<PaymentType> billingPayment);

    List<AllowanceChargeType> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge);

    List<TaxTotalType> getTaxTotal();

    void setTaxTotal(List<TaxTotalType> taxTotal);

    String getId();

    void setId(String value);

}
