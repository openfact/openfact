/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.ConsignmentEntity;
import org.openfact.models.jpa.entities.ubl.common.CountryEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.ConsignmentModel;
import org.openfact.models.ubl.common.ContractModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.DeliveryTermsModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentTermsModel;
import org.openfact.models.ubl.common.TransportationServiceModel;

public class ConsignmentAdapter implements ConsignmentModel, JpaModel<ConsignmentEntity> {

	protected static final Logger logger = Logger.getLogger(ConsignmentAdapter.class);

	protected ConsignmentEntity consignment;
	protected EntityManager em;
	protected OpenfactSession session;

	public ConsignmentAdapter(OpenfactSession session, EntityManager em, ConsignmentEntity consignment) {
		this.session = session;
		this.em = em;
		this.consignment = consignment;
	}

	@Override
	public ConsignmentEntity getEntity() {
		return consignment;
	}

	@Override
	public String getID() {
		return consignment.getID();
	}

	@Override
	public void setID(String value) {
		consignment.setID(value);
	}

	@Override
	public List<String> getSummaryDescription() {
		return consignment.getSummaryDescription();
	}

	@Override
	public void setSummaryDescription(List<String> summaryDescription) {
		consignment.setSummaryDescription(summaryDescription);
	}

	@Override
	public BigDecimal getTotalInvoiceAmount() {
		return consignment.getTotalInvoiceAmount();
	}

	@Override
	public void setTotalInvoiceAmount(BigDecimal value) {
		consignment.setTotalInvoiceAmount(value);
	}

	@Override
	public BigDecimal getDeclaredCustomsValueAmount() {
		return consignment.getDeclaredCustomsValueAmount();
	}

	@Override
	public void setDeclaredCustomsValueAmount(BigDecimal value) {
		consignment.setDeclaredCustomsValueAmount(value);
	}

	@Override
	public List<String> getTariffDescription() {

		return consignment.getTariffDescription();
	}

	@Override
	public void setTariffDescription(List<String> tariffDescription) {
		consignment.setTariffDescription(tariffDescription);
	}

	@Override
	public String getTariffCode() {

		return consignment.getTariffCode();
	}

	@Override
	public void setTariffCode(String value) {
		consignment.setTariffCode(value);
	}

	@Override
	public BigDecimal getInsurancePremiumAmount() {

		return consignment.getInsurancePremiumAmount();
	}

	@Override
	public void setInsurancePremiumAmount(BigDecimal value) {
		consignment.setInsurancePremiumAmount(value);
	}

	@Override
	public MeasureModel getGrossWeightMeasure() {

		return new MeasureAdapter(session, em, consignment.getGrossWeightMeasure());
	}

	@Override
	public void setGrossWeightMeasure(MeasureModel value) {
		consignment.setGrossWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetWeightMeasure() {

		return new MeasureAdapter(session, em, consignment.getNetWeightMeasure());
	}

	@Override
	public void setNetWeightMeasure(MeasureModel value) {
		consignment.setNetWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetNetWeightMeasure() {

		return new MeasureAdapter(session, em, consignment.getNetNetWeightMeasure());
	}

	@Override
	public void setNetNetWeightMeasure(MeasureModel value) {
		consignment.setNetNetWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getChargeableWeightMeasure() {

		return new MeasureAdapter(session, em, consignment.getChargeableWeightMeasure());
	}

	@Override
	public void setChargeableWeightMeasure(MeasureModel value) {
		consignment.setChargeableWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getGrossVolumeMeasure() {

		return new MeasureAdapter(session, em, consignment.getGrossVolumeMeasure());
	}

	@Override
	public void setGrossVolumeMeasure(MeasureModel value) {
		consignment.setGrossVolumeMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetVolumeMeasure() {

		return new MeasureAdapter(session, em, consignment.getNetVolumeMeasure());
	}

	@Override
	public void setNetVolumeMeasure(MeasureModel value) {
		consignment.setNetVolumeMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getLoadingLengthMeasure() {
		return new MeasureAdapter(session, em, consignment.getLoadingLengthMeasure());
	}

	@Override
	public void setLoadingLengthMeasure(MeasureModel value) {
		consignment.setLoadingLengthMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public List<String> getRemarks() {
		return consignment.getRemarks();
	}

	@Override
	public void setRemarks(List<String> remarks) {
		consignment.setRemarks(remarks);
	}

	@Override
	public boolean getHazardousRiskIndicator() {
		return consignment.isHazardousRiskIndicator();
	}

	@Override
	public void setHazardousRiskIndicator(boolean value) {
		consignment.setHazardousRiskIndicator(value);
	}

	@Override
	public PartyModel getConsigneeParty() {
		return new PartyAdapter(session, em, consignment.getConsigneeParty());
	}

	@Override
	public void setConsigneeParty(PartyModel value) {
		consignment.setConsigneeParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getExporterParty() {

		return new PartyAdapter(session, em, consignment.getExporterParty());
	}

	@Override
	public void setExporterParty(PartyModel value) {
		consignment.setExporterParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getConsignorParty() {
		return new PartyAdapter(session, em, consignment.getConsignorParty());
	}

	@Override
	public void setConsignorParty(PartyModel value) {
		consignment.setConsignorParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getImporterParty() {
		return new PartyAdapter(session, em, consignment.getImporterParty());
	}

	@Override
	public void setImporterParty(PartyModel value) {
		consignment.setImporterParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getCarrierParty() {
		return new PartyAdapter(session, em, consignment.getCarrierParty());
	}

	@Override
	public void setCarrierParty(PartyModel value) {
		consignment.setCarrierParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getFreightForwarderParty() {
		return new PartyAdapter(session, em, consignment.getFreightForwarderParty());
	}

	@Override
	public void setFreightForwarderParty(PartyModel value) {
		consignment.setFreightForwarderParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getNotifyParty() {
		return new PartyAdapter(session, em, consignment.getNotifyParty());
	}

	@Override
	public void setNotifyParty(PartyModel value) {
		consignment.setNotifyParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getOriginalDespatchParty() {
		return new PartyAdapter(session, em, consignment.getOriginalDespatchParty());
	}

	@Override
	public void setOriginalDespatchParty(PartyModel value) {
		consignment.setOriginalDespatchParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getFinalDeliveryParty() {
		return new PartyAdapter(session, em, consignment.getFinalDeliveryParty());
	}

	@Override
	public void setFinalDeliveryParty(PartyModel value) {
		consignment.setFinalDeliveryParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public CountryModel getOriginalDepartureCountry() {

		return new CountryAdapter(session, em, consignment.getOriginalDepartureCountry());
	}

	@Override
	public void setOriginalDepartureCountry(CountryModel value) {
		consignment.setOriginalDepartureCountry(CountryAdapter.toEntity(value, em));
	}

	@Override
	public CountryModel getFinalDestinationCountry() {
		return new CountryAdapter(session, em, consignment.getFinalDestinationCountry());
	}

	@Override
	public void setFinalDestinationCountry(CountryModel value) {
		consignment.setFinalDestinationCountry(CountryAdapter.toEntity(value, em));
	}

	@Override
	public List<CountryModel> getTransitCountry() {
		return consignment.getTransitCountry().stream().map(f -> new CountryAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setTransitCountry(List<CountryModel> transitCountry) {
		List<CountryEntity> entities = transitCountry.stream().map(f -> CountryAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		consignment.setTransitCountry(entities);
	}

	@Override
	public ContractModel getTransportContract() {

		return new ContractAdapter(session, em, consignment.getTransportContract());
	}

	@Override
	public void setTransportContract(ContractModel value) {
		consignment.setTransportContract(ContractAdapter.toEntity(value, em));
	}

	@Override
	public TransportationServiceModel getOriginalDespatchTransportationService() {

		return new TransportationServiceAdapter(session, em, consignment.getOriginalDespatchTransportationService());
	}

	@Override
	public void setOriginalDespatchTransportationService(TransportationServiceModel value) {
		consignment.setOriginalDespatchTransportationService(TransportationServiceAdapter.toEntity(value, em));
	}

	@Override
	public TransportationServiceModel getFinalDeliveryTransportationService() {
		return new TransportationServiceAdapter(session, em, consignment.getFinalDeliveryTransportationService());
	}

	@Override
	public void setFinalDeliveryTransportationService(TransportationServiceModel value) {
		consignment.setFinalDeliveryTransportationService(TransportationServiceAdapter.toEntity(value, em));
	}

	@Override
	public DeliveryTermsModel getDeliveryTerms() {
		return new DeliveryTermsAdapter(session, em, consignment.getDeliveryTerms());
	}

	@Override
	public void setDeliveryTerms(DeliveryTermsModel value) {
		consignment.setDeliveryTerms(DeliveryTermsAdapter.toEntity(value, em));
	}

	@Override
	public PaymentTermsModel getPaymentTerms() {

		return new PaymentTermsAdapter(session, em, consignment.getPaymentTerms());
	}

	@Override
	public void setPaymentTerms(PaymentTermsModel value) {
		consignment.setPaymentTerms(PaymentTermsAdapter.toEntity(value, em));
	}

	@Override
	public List<AllowanceChargeModel> getFreightAllowanceCharge() {
		return consignment.getFreightAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge) {
		List<AllowanceChargeEntity> entities = freightAllowanceCharge.stream()
				.map(f -> AllowanceChargeAdapter.toEntity(f, em)).collect(Collectors.toList());
		consignment.setFreightAllowanceCharge(entities);
	}

	@Override
	public String getId() {
		return consignment.getId();
	}

	public static ConsignmentEntity toEntity(ConsignmentModel model, EntityManager em) {
		if (model instanceof ConsignmentAdapter) {
			return ((ConsignmentAdapter) model).getEntity();
		}
		return em.getReference(ConsignmentEntity.class, model.getId());
	}

}
