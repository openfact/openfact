package org.openfact.models.ubl.common;

import java.util.List;

public interface ContactType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    TelephoneType getTelephone();

    void setTelephone(TelephoneType value);

    TelefaxType getTelefax();

    void setTelefax(TelefaxType value);

    ElectronicMailType getElectronicMail();

    void setElectronicMail(ElectronicMailType value);

    NoteType getNote();

    void setNote(NoteType value);

    List<CommunicationType> getOtherCommunication();

    void setOtherCommunication(List<CommunicationType> otherCommunication);

    String getId();

    void setId(String value);

}
