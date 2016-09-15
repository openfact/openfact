package org.openfact.models.ubl;

import java.time.LocalDate;
import java.util.List;

import org.openfact.models.ubl.common.ReferenceDateModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SummaryDocumentsLineModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public interface SummaryDocumentsModel {

    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    String getUBLVersionID();

    void setUBLVersionID(String value);

    String getCustomizationID();

    void setCustomizationID(String value);

    String getID();

    void setID(String value);

    ReferenceDateModel getReferenceDate();

    void setReferenceDate(ReferenceDateModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    List<String> getNote();

    void setNote(List<String> note);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    List<SummaryDocumentsLineModel> getSummaryDocumentsLine();

    void setSummaryDocumentsLine(List<SummaryDocumentsLineModel> summaryDocumentsLine);

    String getId();

    void setId(String value);

}
