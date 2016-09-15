package org.openfact.models.ubl.common;

import java.util.List;

public interface ShipmentStageType {

    IDType getID();

    void setID(IDType value);

    TransportModeCodeTypeCommBas getTransportModeCode();

    void setTransportModeCode(TransportModeCodeTypeCommBas value);

    TransportMeansTypeCodeType getTransportMeansTypeCode();

    void setTransportMeansTypeCode(TransportMeansTypeCodeType value);

    TransitDirectionCodeType getTransitDirectionCode();

    void setTransitDirectionCode(TransitDirectionCodeType value);

    PreCarriageIndicatorType getPreCarriageIndicator();

    void setPreCarriageIndicator(PreCarriageIndicatorType value);

    OnCarriageIndicatorType getOnCarriageIndicator();

    void setOnCarriageIndicator(OnCarriageIndicatorType value);

    PeriodType getTransitPeriod();

    void setTransitPeriod(PeriodType value);

    List<PartyType> getCarrierParty();

    void setCarrierParty(List<PartyType> carrierParty);

    TransportMeansType getTransportMeans();

    void setTransportMeans(TransportMeansType value);

    LocationTypeCommAgg getLoadingPortLocation();

    void setLoadingPortLocation(LocationTypeCommAgg value);

    LocationTypeCommAgg getUnloadingPortLocation();

    void setUnloadingPortLocation(LocationTypeCommAgg value);

    LocationTypeCommAgg getTransshipPortLocation();

    void setTransshipPortLocation(LocationTypeCommAgg value);

    String getId();

    void setId(String value);

}
