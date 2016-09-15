package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportMeansModel {

    JourneyIDModel getJourneyID();

    void setJourneyID(JourneyIDModel value);

    RegistrationNationalityIDModel getRegistrationNationalityID();

    void setRegistrationNationalityID(RegistrationNationalityIDModel value);

    List<RegistrationNationalityModel> getRegistrationNationality();

    void setRegistrationNationality(List<RegistrationNationalityModel> registrationNationality);

    DirectionCodeModel getDirectionCode();

    void setDirectionCode(DirectionCodeModel value);

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

    void setId(String value);

}
