package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.common.CustomizationIDType;
import org.openfact.models.ubl.common.DocumentResponseType;
import org.openfact.models.ubl.common.IDType;
import org.openfact.models.ubl.common.IssueDateType;
import org.openfact.models.ubl.common.IssueTimeType;
import org.openfact.models.ubl.common.NoteType;
import org.openfact.models.ubl.common.PartyType;
import org.openfact.models.ubl.common.ProfileIDType;
import org.openfact.models.ubl.common.ResponseDateType;
import org.openfact.models.ubl.common.ResponseTimeType;
import org.openfact.models.ubl.common.SignatureType;
import org.openfact.models.ubl.common.UBLExtensionsType;
import org.openfact.models.ubl.common.UBLVersionIDType;
import org.openfact.models.ubl.common.UUIDType;
import org.openfact.models.ubl.common.VersionIDType;

public interface ApplicationResponseType {

    UBLExtensionsType getUBLExtensions();

    void setUBLExtensions(UBLExtensionsType value);

    UBLVersionIDType getUBLVersionID();

    void setUBLVersionID(UBLVersionIDType value);

    CustomizationIDType getCustomizationID();

    void setCustomizationID(CustomizationIDType value);

    ProfileIDType getProfileID();

    void setProfileID(ProfileIDType value);

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    IssueTimeType getIssueTime();

    void setIssueTime(IssueTimeType value);

    ResponseDateType getResponseDate();

    void setResponseDate(ResponseDateType value);

    ResponseTimeType getResponseTime();

    void setResponseTime(ResponseTimeType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    VersionIDType getVersionID();

    void setVersionID(VersionIDType value);

    List<SignatureType> getSignature();

    void setSignature(List<SignatureType> signature);

    PartyType getSenderParty();

    void setSenderParty(PartyType value);

    PartyType getReceiverParty();

    void setReceiverParty(PartyType value);

    List<DocumentResponseType> getDocumentResponse();

    void setDocumentResponse(List<DocumentResponseType> documentResponse);

    String getId();

    void setId(String value);

}
