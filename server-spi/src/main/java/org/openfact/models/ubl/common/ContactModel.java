package org.openfact.models.ubl.common;

import java.util.List;

public interface ContactModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    String getTelephone();

    void setTelephone(String value);

    String getTelefax();

    void setTelefax(String value);

    String getElectronicMail();

    void setElectronicMail(String value);

    String getNote();

    void setNote(String value);

    List<CommunicationModel> getOtherCommunication();

    void setOtherCommunication(List<CommunicationModel> otherCommunication);

    String getId();

    void setId(String value);

}
