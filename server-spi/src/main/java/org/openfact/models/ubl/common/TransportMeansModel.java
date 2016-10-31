package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportMeansModel {

    String getJourneyID();

    void setJourneyID(String value);

    String getRegistrationNationalityID();

    void setRegistrationNationalityID(String value);

    List<String> getRegistrationNationality();

    void setRegistrationNationality(List<String> registrationNationality);

    String getDirectionCode();

    void setDirectionCode(String value);

    StowageModel getStowage();

    void setStowage(StowageModel value);

    AirTransportModel getAirTransport();

    void setAirTransport(AirTransportModel value);

    RoadTransportModel getRoadTransport();

    void setRoadTransport(RoadTransportModel value);

    RailTransportModel getRailTransport();

    void setRailTransport(RailTransportModel value);

    MaritimeTransportModel getMaritimeTransport();

    void setMaritimeTransport(MaritimeTransportModel value);

    PartyModel getOwnerParty();

    void setOwnerParty(PartyModel value);

    String getId();

    

}
