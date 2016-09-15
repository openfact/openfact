package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.common.CustomizationIDType;
import org.openfact.models.ubl.common.IDType;
import org.openfact.models.ubl.common.IssueDateType;
import org.openfact.models.ubl.common.NoteType;
import org.openfact.models.ubl.common.ReferenceDateType;
import org.openfact.models.ubl.common.SignatureType;
import org.openfact.models.ubl.common.SummaryDocumentsLineType;
import org.openfact.models.ubl.common.SupplierPartyType;
import org.openfact.models.ubl.common.UBLExtensionsType;
import org.openfact.models.ubl.common.UBLVersionIDType;

public interface SummaryDocumentsType {

    UBLExtensionsType getUBLExtensions();

    void setUBLExtensions(UBLExtensionsType value);

    UBLVersionIDType getUBLVersionID();

    void setUBLVersionID(UBLVersionIDType value);

    CustomizationIDType getCustomizationID();

    void setCustomizationID(CustomizationIDType value);

    IDType getID();

    void setID(IDType value);

    ReferenceDateType getReferenceDate();

    void setReferenceDate(ReferenceDateType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    List<SignatureType> getSignature();

    void setSignature(List<SignatureType> signature);

    SupplierPartyType getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyType value);

    List<SummaryDocumentsLineType> getSummaryDocumentsLine();

    void setSummaryDocumentsLine(List<SummaryDocumentsLineType> summaryDocumentsLine);

    String getId();

    void setId(String value);

}
