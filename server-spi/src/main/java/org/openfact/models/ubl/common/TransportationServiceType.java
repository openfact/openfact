package org.openfact.models.ubl.common;

public interface TransportationServiceType {

    TransportServiceCodeType getTransportServiceCode();

    void setTransportServiceCode(TransportServiceCodeType value);

    TariffClassCodeType getTariffClassCode();

    void setTariffClassCode(TariffClassCodeType value);

    PriorityType getPriority();

    void setPriority(PriorityType value);

    FreightRateClassCodeType getFreightRateClassCode();

    void setFreightRateClassCode(FreightRateClassCodeType value);

    String getId();

    void setId(String value);

}
