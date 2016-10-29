package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "CONSIGNMENT")
public class ConsignmentEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "SUMMARYDESCRIPTION_CONSIGNMENT", joinColumns = { @JoinColumn(name = "CONSIGNMENT_ID") })
	protected List<String> summaryDescription = new ArrayList<>();

	@Column(name = "TOTAL_INVOICE_AMOUNT")
	protected BigDecimal totalInvoiceAmount;

	@Column(name = "DECLARED_CUSTOMS_VALUE_AMOUNT")
	protected BigDecimal declaredCustomsValueAmount;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "TARIFFDESCRIPTION_CONSIGNMENT", joinColumns = { @JoinColumn(name = "CONSIGNMENT_ID") })
	protected List<String> tariffDescription = new ArrayList<>();

	@Column(name = "TARIFF_CODE")
	protected String tariffCode;

	@Column(name = "INSURANCE_PREMIUM_AMOUNT")
	protected BigDecimal insurancePremiumAmount;

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GROSSWEIGHTMEASURE_CONSIGNMENT")
	protected MeasureEntity grossWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETWEIGHTMEASURE_CONSIGNMENT")
	protected MeasureEntity netWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETNETWEIGHTMEASURE_CONSIGNMENT")
	protected MeasureEntity netNetWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CHARGEABLEWEIGHTMEASURE_CONSIGNMENT")
	protected MeasureEntity chargeableWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GROSSVOLUMEMEASURE_CONSIGNMENT")
	protected MeasureEntity grossVolumeMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETVOLUMEMEASURE_CONSIGNMENT")
	protected MeasureEntity netVolumeMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LOADINGLENGTHMEASURE_CONSIGNMENT")
	protected MeasureEntity loadingLengthMeasure = new MeasureEntity();

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "REMARKS_CONSIGNMENT", joinColumns = { @JoinColumn(name = "CONSIGNMENT_ID") })
	protected List<String> remarks = new ArrayList<>();

	@Column(name = "HAZARDOUS_RISK_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean hazardousRiskIndicator;

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSIGNEEPARTY_CONSIGNMENT")
	protected PartyEntity consigneeParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "EXPORTERPARTY_CONSIGNMENT")
	protected PartyEntity exporterParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONSIGNORPARTY_CONSIGNMENT")
	protected PartyEntity consignorParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "IMPORTERPARTY_CONSIGNMENT")
	protected PartyEntity importerParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CARRIERPARTY_CONSIGNMENT")
	protected PartyEntity carrierParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FREIGHTFORWARDERPARTY_CONSIGNMENT")
	protected PartyEntity freightForwarderParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NOTIFYPARTY_CONSIGNMENT")
	protected PartyEntity notifyParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINALDESPATCHPARTY_CONSIGNMENT")
	protected PartyEntity originalDespatchParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FINALDELIVERYPARTY_CONSIGNMENT")
	protected PartyEntity finalDeliveryParty = new PartyEntity();

	@ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINALDEPARTURECOUNTRY_CONSIGNMENT")
	protected CountryEntity originalDepartureCountry = new CountryEntity();

	@ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FINALDESTINATIONCOUNTRY_CONSGINMENT")
	protected CountryEntity finalDestinationCountry = new CountryEntity();

	@OneToMany(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSITCOUNTRY_CONSIGNMENT")
	protected List<CountryEntity> transitCountry = new ArrayList<>();

	@ManyToOne(targetEntity = ContractEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TRANSPORTCONTRACT_CONSIGNMENT")
	protected ContractEntity transportContract = new ContractEntity();

	@ManyToOne(targetEntity = TransportationServiceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINALDESPATCHTRANSPORTATI")
	protected TransportationServiceEntity originalDespatchTransportationService = new TransportationServiceEntity();

	@ManyToOne(targetEntity = TransportationServiceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FINALDELIVERYTRANSPORTATIONS")
	protected TransportationServiceEntity finalDeliveryTransportationService = new TransportationServiceEntity();

	@ManyToOne(targetEntity = DeliveryTermsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERYTERMS_CONSIGNMENT")
	protected DeliveryTermsEntity deliveryTerms = new DeliveryTermsEntity();

	@ManyToOne(targetEntity = PaymentTermsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYMENTTERMS_CONSIGNMENT")
	protected PaymentTermsEntity paymentTerms = new PaymentTermsEntity();

	@OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FREIGHTALLOWANCECHARGE_CONSIGNMENT")
	protected List<AllowanceChargeEntity> freightAllowanceCharge = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public List<String> getSummaryDescription() {
		return summaryDescription;
	}

	public void setSummaryDescription(List<String> summaryDescription) {
		this.summaryDescription = summaryDescription;
	}

	public BigDecimal getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}

	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}

	public BigDecimal getDeclaredCustomsValueAmount() {
		return declaredCustomsValueAmount;
	}

	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		this.declaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	public List<String> getTariffDescription() {
		return tariffDescription;
	}

	public void setTariffDescription(List<String> tariffDescription) {
		this.tariffDescription = tariffDescription;
	}

	public String getTariffCode() {
		return tariffCode;
	}

	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}

	public BigDecimal getInsurancePremiumAmount() {
		return insurancePremiumAmount;
	}

	public void setInsurancePremiumAmount(BigDecimal insurancePremiumAmount) {
		this.insurancePremiumAmount = insurancePremiumAmount;
	}

	public MeasureEntity getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(MeasureEntity grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public MeasureEntity getNetWeightMeasure() {
		return netWeightMeasure;
	}

	public void setNetWeightMeasure(MeasureEntity netWeightMeasure) {
		this.netWeightMeasure = netWeightMeasure;
	}

	public MeasureEntity getNetNetWeightMeasure() {
		return netNetWeightMeasure;
	}

	public void setNetNetWeightMeasure(MeasureEntity netNetWeightMeasure) {
		this.netNetWeightMeasure = netNetWeightMeasure;
	}

	public MeasureEntity getChargeableWeightMeasure() {
		return chargeableWeightMeasure;
	}

	public void setChargeableWeightMeasure(MeasureEntity chargeableWeightMeasure) {
		this.chargeableWeightMeasure = chargeableWeightMeasure;
	}

	public MeasureEntity getGrossVolumeMeasure() {
		return grossVolumeMeasure;
	}

	public void setGrossVolumeMeasure(MeasureEntity grossVolumeMeasure) {
		this.grossVolumeMeasure = grossVolumeMeasure;
	}

	public MeasureEntity getNetVolumeMeasure() {
		return netVolumeMeasure;
	}

	public void setNetVolumeMeasure(MeasureEntity netVolumeMeasure) {
		this.netVolumeMeasure = netVolumeMeasure;
	}

	public MeasureEntity getLoadingLengthMeasure() {
		return loadingLengthMeasure;
	}

	public void setLoadingLengthMeasure(MeasureEntity loadingLengthMeasure) {
		this.loadingLengthMeasure = loadingLengthMeasure;
	}

	public List<String> getRemarks() {
		return remarks;
	}

	public void setRemarks(List<String> remarks) {
		this.remarks = remarks;
	}

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public PartyEntity getConsigneeParty() {
		return consigneeParty;
	}

	public void setConsigneeParty(PartyEntity consigneeParty) {
		this.consigneeParty = consigneeParty;
	}

	public PartyEntity getExporterParty() {
		return exporterParty;
	}

	public void setExporterParty(PartyEntity exporterParty) {
		this.exporterParty = exporterParty;
	}

	public PartyEntity getConsignorParty() {
		return consignorParty;
	}

	public void setConsignorParty(PartyEntity consignorParty) {
		this.consignorParty = consignorParty;
	}

	public PartyEntity getImporterParty() {
		return importerParty;
	}

	public void setImporterParty(PartyEntity importerParty) {
		this.importerParty = importerParty;
	}

	public PartyEntity getCarrierParty() {
		return carrierParty;
	}

	public void setCarrierParty(PartyEntity carrierParty) {
		this.carrierParty = carrierParty;
	}

	public PartyEntity getFreightForwarderParty() {
		return freightForwarderParty;
	}

	public void setFreightForwarderParty(PartyEntity freightForwarderParty) {
		this.freightForwarderParty = freightForwarderParty;
	}

	public PartyEntity getNotifyParty() {
		return notifyParty;
	}

	public void setNotifyParty(PartyEntity notifyParty) {
		this.notifyParty = notifyParty;
	}

	public PartyEntity getOriginalDespatchParty() {
		return originalDespatchParty;
	}

	public void setOriginalDespatchParty(PartyEntity originalDespatchParty) {
		this.originalDespatchParty = originalDespatchParty;
	}

	public PartyEntity getFinalDeliveryParty() {
		return finalDeliveryParty;
	}

	public void setFinalDeliveryParty(PartyEntity finalDeliveryParty) {
		this.finalDeliveryParty = finalDeliveryParty;
	}

	public CountryEntity getOriginalDepartureCountry() {
		return originalDepartureCountry;
	}

	public void setOriginalDepartureCountry(CountryEntity originalDepartureCountry) {
		this.originalDepartureCountry = originalDepartureCountry;
	}

	public CountryEntity getFinalDestinationCountry() {
		return finalDestinationCountry;
	}

	public void setFinalDestinationCountry(CountryEntity finalDestinationCountry) {
		this.finalDestinationCountry = finalDestinationCountry;
	}

	public List<CountryEntity> getTransitCountry() {
		return transitCountry;
	}

	public void setTransitCountry(List<CountryEntity> transitCountry) {
		this.transitCountry = transitCountry;
	}

	public ContractEntity getTransportContract() {
		return transportContract;
	}

	public void setTransportContract(ContractEntity transportContract) {
		this.transportContract = transportContract;
	}

	public TransportationServiceEntity getOriginalDespatchTransportationService() {
		return originalDespatchTransportationService;
	}

	public void setOriginalDespatchTransportationService(
			TransportationServiceEntity originalDespatchTransportationService) {
		this.originalDespatchTransportationService = originalDespatchTransportationService;
	}

	public TransportationServiceEntity getFinalDeliveryTransportationService() {
		return finalDeliveryTransportationService;
	}

	public void setFinalDeliveryTransportationService(TransportationServiceEntity finalDeliveryTransportationService) {
		this.finalDeliveryTransportationService = finalDeliveryTransportationService;
	}

	public DeliveryTermsEntity getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(DeliveryTermsEntity deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public PaymentTermsEntity getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(PaymentTermsEntity paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public List<AllowanceChargeEntity> getFreightAllowanceCharge() {
		return freightAllowanceCharge;
	}

	public void setFreightAllowanceCharge(List<AllowanceChargeEntity> freightAllowanceCharge) {
		this.freightAllowanceCharge = freightAllowanceCharge;
	}

}
