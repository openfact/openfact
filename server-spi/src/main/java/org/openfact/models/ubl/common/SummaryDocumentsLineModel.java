package org.openfact.models.ubl.common;

import java.util.List;

public interface SummaryDocumentsLineModel {

    LineIDModel getLineID();

    void setLineID(LineIDModel value);

    String getDocumentModelCode();

    void setDocumentModelCode(String value);

    IdentifierModel getDocumentSerialID();

    void setDocumentSerialID(IdentifierModel value);

    IdentifierModel getStartDocumentNumberID();

    void setStartDocumentNumberID(IdentifierModel value);

    IdentifierModel getEndDocumentNumberID();

    void setEndDocumentNumberID(IdentifierModel value);

    AmountModelCommBas getTotalAmount();

    void setTotalAmount(AmountModelCommBas value);

    List<PaymentModel> getBillingPayment();

    void setBillingPayment(List<PaymentModel> billingPayment);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    String getId();

    void setId(String value);

}
