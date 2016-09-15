package org.openfact.models.ubl.common;

public interface SecondaryHazardModel {

    IDModel getID();

    void setID(IDModel value);

    PlacardNotationModel getPlacardNotation();

    void setPlacardNotation(PlacardNotationModel value);

    PlacardEndorsementModel getPlacardEndorsement();

    void setPlacardEndorsement(PlacardEndorsementModel value);

    EmergencyProceduresCodeModel getEmergencyProceduresCode();

    void setEmergencyProceduresCode(EmergencyProceduresCodeModel value);

    ExtensionModel getExtension();

    void setExtension(ExtensionModel value);

    String getId();

    void setId(String value);

}
