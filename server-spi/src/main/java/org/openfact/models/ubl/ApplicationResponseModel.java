package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openfact.models.ubl.common.DocumentResponseModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.ResponseDateModel;
import org.openfact.models.ubl.common.ResponseTimeModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public interface ApplicationResponseModel {

    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    String getUBLVersionID();

    void setUBLVersionID(String value);

    String getCustomizationID();

    void setCustomizationID(String value);

    String getProfileID();

    void setProfileID(String value);

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    ResponseDateModel getResponseDate();

    void setResponseDate(ResponseDateModel value);

    ResponseTimeModel getResponseTime();

    void setResponseTime(ResponseTimeModel value);

    List<String> getNote();

    void setNote(List<String> note);

    String getVersionID();

    void setVersionID(String value);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    PartyModel getSenderParty();

    void setSenderParty(PartyModel value);

    PartyModel getReceiverParty();

    void setReceiverParty(PartyModel value);

    List<DocumentResponseModel> getDocumentResponse();

    void setDocumentResponse(List<DocumentResponseModel> documentResponse);

    String getId();

    void setId(String value);

}
