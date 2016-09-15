package org.openfact.models.ubl.common;

import java.util.List;

public interface ConsignmentType {

    IDType getID();

    void setID(IDType value);

    List<SummaryDescriptionType> getSummaryDescription();

    void setSummaryDescription(List<SummaryDescriptionType> summaryDescription);

    TotalInvoiceAmountType getTotalInvoiceAmount();

    void setTotalInvoiceAmount(TotalInvoiceAmountType value);

    DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value);

    List<TariffDescriptionType> getTariffDescription();

    void setTariffDescription(List<TariffDescriptionType> tariffDescription);

    TariffCodeType getTariffCode();

    void setTariffCode(TariffCodeType value);

    InsurancePremiumAmountType getInsurancePremiumAmount();

    void setInsurancePremiumAmount(InsurancePremiumAmountType value);

    GrossWeightMeasureType getGrossWeightMeasure();

    void setGrossWeightMeasure(GrossWeightMeasureType value);

    NetWeightMeasureType getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureType value);

    NetNetWeightMeasureType getNetNetWeightMeasure();

    void setNetNetWeightMeasure(NetNetWeightMeasureType value);

    ChargeableWeightMeasureType getChargeableWeightMeasure();

    void setChargeableWeightMeasure(ChargeableWeightMeasureType value);

    GrossVolumeMeasureType getGrossVolumeMeasure();

    void setGrossVolumeMeasure(GrossVolumeMeasureType value);

    NetVolumeMeasureType getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureType value);

    LoadingLengthMeasureType getLoadingLengthMeasure();

    void setLoadingLengthMeasure(LoadingLengthMeasureType value);

    List<RemarksType> getRemarks();

    void setRemarks(List<RemarksType> remarks);

    HazardousRiskIndicatorType getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorType value);

    PartyType getConsigneeParty();

    void setConsigneeParty(PartyType value);

    PartyType getExporterParty();

    void setExporterParty(PartyType value);

    PartyType getConsignorParty();

    void setConsignorParty(PartyType value);

    PartyType getImporterParty();

    void setImporterParty(PartyType value);

    PartyType getCarrierParty();

    void setCarrierParty(PartyType value);

    PartyType getFreightForwarderParty();

    void setFreightForwarderParty(PartyType value);

    PartyType getNotifyParty();

    void setNotifyParty(PartyType value);

    PartyType getOriginalDespatchParty();

    void setOriginalDespatchParty(PartyType value);

    PartyType getFinalDeliveryParty();

    void setFinalDeliveryParty(PartyType value);

    CountryType getOriginalDepartureCountry();

    void setOriginalDepartureCountry(CountryType value);

    CountryType getFinalDestinationCountry();

    void setFinalDestinationCountry(CountryType value);

    List<CountryType> getTransitCountry();

    void setTransitCountry(List<CountryType> transitCountry);

    ContractType getTransportContract();

    void setTransportContract(ContractType value);

    TransportationServiceType getOriginalDespatchTransportationService();

    void setOriginalDespatchTransportationService(TransportationServiceType value);

    TransportationServiceType getFinalDeliveryTransportationService();

    void setFinalDeliveryTransportationService(TransportationServiceType value);

    DeliveryTermsType getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsType value);

    PaymentTermsType getPaymentTerms();

    void setPaymentTerms(PaymentTermsType value);

    List<AllowanceChargeType> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeType> freightAllowanceCharge);

    String getId();

    void setId(String value);

}
