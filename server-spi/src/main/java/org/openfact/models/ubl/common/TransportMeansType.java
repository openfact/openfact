package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportMeansType {

    JourneyIDType getJourneyID();

    void setJourneyID(JourneyIDType value);

    RegistrationNationalityIDType getRegistrationNationalityID();

    void setRegistrationNationalityID(RegistrationNationalityIDType value);

    List<RegistrationNationalityType> getRegistrationNationality();

    void setRegistrationNationality(List<RegistrationNationalityType> registrationNationality);

    DirectionCodeType getDirectionCode();

    void setDirectionCode(DirectionCodeType value);

    StowageType getStowage();

    void setStowage(StowageType value);

    AirTransportType getAirTransport();

    void setAirTransport(AirTransportType value);

    RoadTransportType getRoadTransport();

    void setRoadTransport(RoadTransportType value);

    RailTransportType getRailTransport();

    void setRailTransport(RailTransportType value);

    MaritimeTransportType getMaritimeTransport();

    void setMaritimeTransport(MaritimeTransportType value);

    PartyType getOwnerParty();

    void setOwnerParty(PartyType value);

    String getId();

    void setId(String value);

}
