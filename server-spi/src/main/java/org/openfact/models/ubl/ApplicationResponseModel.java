package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openfact.models.ubl.common.CustomizationIDModel;
import org.openfact.models.ubl.common.DocumentResponseModel;
import org.openfact.models.ubl.common.IDModel;
import org.openfact.models.ubl.common.NoteModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.ProfileIDModel;
import org.openfact.models.ubl.common.ResponseDateModel;
import org.openfact.models.ubl.common.ResponseTimeModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.UBLVersionIDModel;
import org.openfact.models.ubl.common.UUIDModel;
import org.openfact.models.ubl.common.VersionIDModel;

public interface ApplicationResponseModel {

    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    UBLVersionIDModel getUBLVersionID();

    void setUBLVersionID(UBLVersionIDModel value);

    CustomizationIDModel getCustomizationID();

    void setCustomizationID(CustomizationIDModel value);

    ProfileIDModel getProfileID();

    void setProfileID(ProfileIDModel value);

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    ResponseDateModel getResponseDate();

    void setResponseDate(ResponseDateModel value);

    ResponseTimeModel getResponseTime();

    void setResponseTime(ResponseTimeModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

    VersionIDModel getVersionID();

    void setVersionID(VersionIDModel value);

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
