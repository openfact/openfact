package org.openfact.models.ubl.common;

import java.util.List;

public interface ConsignmentModel {

    String getID();

    void setID(String value);

    List<String> getSummaryDescription();

    void setSummaryDescription(List<String> summaryDescription);

    TotalInvoiceAmountModel getTotalInvoiceAmount();

    void setTotalInvoiceAmount(TotalInvoiceAmountModel value);

    DeclaredCustomsValueAmountModel getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountModel value);

    List<String> getTariffDescription();

    void setTariffDescription(List<String> tariffDescription);

    String getTariffCode();

    void setTariffCode(String value);

    InsurancePremiumAmountModel getInsurancePremiumAmount();

    void setInsurancePremiumAmount(InsurancePremiumAmountModel value);

    GrossWeightMeasureModel getGrossWeightMeasure();

    void setGrossWeightMeasure(GrossWeightMeasureModel value);

    NetWeightMeasureModel getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureModel value);

    NetNetWeightMeasureModel getNetNetWeightMeasure();

    void setNetNetWeightMeasure(NetNetWeightMeasureModel value);

    ChargeableWeightMeasureModel getChargeableWeightMeasure();

    void setChargeableWeightMeasure(ChargeableWeightMeasureModel value);

    GrossVolumeMeasureModel getGrossVolumeMeasure();

    void setGrossVolumeMeasure(GrossVolumeMeasureModel value);

    NetVolumeMeasureModel getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureModel value);

    LoadingLengthMeasureModel getLoadingLengthMeasure();

    void setLoadingLengthMeasure(LoadingLengthMeasureModel value);

    List<String> getRemarks();

    void setRemarks(List<String> remarks);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    PartyModel getConsigneeParty();

    void setConsigneeParty(PartyModel value);

    PartyModel getExporterParty();

    void setExporterParty(PartyModel value);

    PartyModel getConsignorParty();

    void setConsignorParty(PartyModel value);

    PartyModel getImporterParty();

    void setImporterParty(PartyModel value);

    PartyModel getCarrierParty();

    void setCarrierParty(PartyModel value);

    PartyModel getFreightForwarderParty();

    void setFreightForwarderParty(PartyModel value);

    PartyModel getNotifyParty();

    void setNotifyParty(PartyModel value);

    PartyModel getOriginalDespatchParty();

    void setOriginalDespatchParty(PartyModel value);

    PartyModel getFinalDeliveryParty();

    void setFinalDeliveryParty(PartyModel value);

    CountryModel getOriginalDepartureCountry();

    void setOriginalDepartureCountry(CountryModel value);

    CountryModel getFinalDestinationCountry();

    void setFinalDestinationCountry(CountryModel value);

    List<CountryModel> getTransitCountry();

    void setTransitCountry(List<CountryModel> transitCountry);

    ContractModel getTransportContract();

    void setTransportContract(ContractModel value);

    TransportationServiceModel getOriginalDespatchTransportationService();

    void setOriginalDespatchTransportationService(TransportationServiceModel value);

    TransportationServiceModel getFinalDeliveryTransportationService();

    void setFinalDeliveryTransportationService(TransportationServiceModel value);

    DeliveryTermsModel getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsModel value);

    PaymentTermsModel getPaymentTerms();

    void setPaymentTerms(PaymentTermsModel value);

    List<AllowanceChargeModel> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge);

    String getId();

    void setId(String value);

}
