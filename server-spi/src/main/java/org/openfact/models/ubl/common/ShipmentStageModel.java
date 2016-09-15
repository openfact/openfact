package org.openfact.models.ubl.common;

import java.util.List;

public interface ShipmentStageModel {

    IDModel getID();

    void setID(IDModel value);

    TransportModeCodeModelCommBas getTransportModeCode();

    void setTransportModeCode(TransportModeCodeModelCommBas value);

    TransportMeansModelCodeModel getTransportMeansModelCode();

    void setTransportMeansModelCode(TransportMeansModelCodeModel value);

    TransitDirectionCodeModel getTransitDirectionCode();

    void setTransitDirectionCode(TransitDirectionCodeModel value);

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
