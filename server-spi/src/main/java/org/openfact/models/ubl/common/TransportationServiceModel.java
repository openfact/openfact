package org.openfact.models.ubl.common;

public interface TransportationServiceModel {

    TransportServiceCodeModel getTransportServiceCode();

    void setTransportServiceCode(TransportServiceCodeModel value);

    TariffClassCodeModel getTariffClassCode();

    void setTariffClassCode(TariffClassCodeModel value);

    PriorityModel getPriority();

    void setPriority(PriorityModel value);

    FreightRateClassCodeModel getFreightRateClassCode();

    void setFreightRateClassCode(FreightRateClassCodeModel value);

    String getId();

    void setId(String value);

}
