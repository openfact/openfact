package org.openfact.models.ubl.common;

import java.util.List;

public interface ContactModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    TelephoneModel getTelephone();

    void setTelephone(TelephoneModel value);

    TelefaxModel getTelefax();

    void setTelefax(TelefaxModel value);

    ElectronicMailModel getElectronicMail();

    void setElectronicMail(ElectronicMailModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    List<CommunicationModel> getOtherCommunication();

    void setOtherCommunication(List<CommunicationModel> otherCommunication);

    String getId();

    void setId(String value);

}
