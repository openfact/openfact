package org.openfact.models.ubl.common;

import java.util.List;

public interface ShipmentStageModel {

    String getID();

    void setID(String value);

    String getTransportModeCode();

    void setTransportModeCode(String value);

    String getTransportMeansModelCode();

    void setTransportMeansModelCode(String value);

    String getTransitDirectionCode();

    void setTransitDirectionCode(String value);

    PreCarriageIndicatorModel getPreCarriageIndicator();

    void setPreCarriageIndicator(PreCarriageIndicatorModel value);

    OnCarriageIndicatorModel getOnCarriageIndicator();

    void setOnCarriageIndicator(OnCarriageIndicatorModel value);

    PeriodModel getTransitPeriod();

    void setTransitPeriod(PeriodModel value);

    List<PartyModel> getCarrierParty();

    void setCarrierParty(List<PartyModel> carrierParty);

    TransportMeansModel getTransportMeans();

    void setTransportMeans(TransportMeansModel value);

    LocationModelCommAgg getLoadingPortLocation();

    void setLoadingPortLocation(LocationModelCommAgg value);

    LocationModelCommAgg getUnloadingPortLocation();

    void setUnloadingPortLocation(LocationModelCommAgg value);

    LocationModelCommAgg getTransshipPortLocation();

    void setTransshipPortLocation(LocationModelCommAgg value);

    String getId();

    void setId(String value);

}
