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

    boolean getPreCarriageIndicator();

    void setPreCarriageIndicator(boolean value);

    boolean getOnCarriageIndicator();

    void setOnCarriageIndicator(boolean value);

    PeriodModel getTransitPeriod();

    void setTransitPeriod(PeriodModel value);

    List<PartyModel> getCarrierParty();

    void setCarrierParty(List<PartyModel> carrierParty);

    TransportMeansModel getTransportMeans();

    void setTransportMeans(TransportMeansModel value);

    LocationCommAggModel getLoadingPortLocation();

    void setLoadingPortLocation(LocationCommAggModel value);

    LocationCommAggModel getUnloadingPortLocation();

    void setUnloadingPortLocation(LocationCommAggModel value);

    LocationCommAggModel getTransshipPortLocation();

    void setTransshipPortLocation(LocationCommAggModel value);

    String getId();

    void setId(String value);

}
