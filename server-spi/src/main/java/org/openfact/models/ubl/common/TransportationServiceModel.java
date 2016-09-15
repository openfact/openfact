package org.openfact.models.ubl.common;

public interface TransportationServiceModel {

    String getTransportServiceCode();

    void setTransportServiceCode(String value);

    String getTariffClassCode();

    void setTariffClassCode(String value);

    PriorityModel getPriority();

    void setPriority(PriorityModel value);

    String getFreightRateClassCode();

    void setFreightRateClassCode(String value);

    String getId();

    void setId(String value);

}
