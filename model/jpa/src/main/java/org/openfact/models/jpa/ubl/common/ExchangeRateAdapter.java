package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ExchangeRateEntity;
import org.openfact.models.ubl.common.ContractModel;
import org.openfact.models.ubl.common.ExchangeRateModel;

public class ExchangeRateAdapter implements ExchangeRateModel, JpaModel<ExchangeRateEntity> {

	protected static final Logger logger = Logger.getLogger(ExchangeRateAdapter.class);
	protected ExchangeRateEntity exchangeRate;
	protected EntityManager em;
	protected OpenfactSession session;

	public ExchangeRateAdapter(OpenfactSession session, EntityManager em, ExchangeRateEntity exchangeRate) {
		this.session = session;
		this.em = em;
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String getSourceCurrencyCode() {
		return this.exchangeRate.getSourceCurrencyCode();
	}

	@Override
	public void setSourceCurrencyCode(String value) {
		this.exchangeRate.setSourceCurrencyCode(value);
	}

	@Override
	public BigDecimal getSourceCurrencyBaseRate() {
		return this.exchangeRate.getSourceCurrencyBaseRate();
	}

	@Override
	public void setSourceCurrencyBaseRate(BigDecimal value) {
		this.exchangeRate.setSourceCurrencyBaseRate(value);
	}

	@Override
	public String getTargetCurrencyCode() {
		return this.exchangeRate.getTargetCurrencyCode();
	}

	@Override
	public void setTargetCurrencyCode(String value) {
		this.exchangeRate.setTargetCurrencyCode(value);
	}

	@Override
	public BigDecimal getTargetCurrencyBaseRate() {
		return this.exchangeRate.getTargetCurrencyBaseRate();
	}

	@Override
	public void setTargetCurrencyBaseRate(BigDecimal value) {
		this.exchangeRate.setTargetCurrencyBaseRate(value);
	}

	@Override
	public String getExchangeMarketID() {
		return this.exchangeRate.getExchangeMarketID();
	}

	@Override
	public void setExchangeMarketID(String value) {
		this.exchangeRate.setExchangeMarketID(value);
	}

	@Override
	public BigDecimal getCalculationRate() {
		return this.exchangeRate.getCalculationRate();
	}

	@Override
	public void setCalculationRate(BigDecimal value) {
		this.exchangeRate.setCalculationRate(value);
	}

	@Override
	public String getMathematicOperatorCode() {
		return this.exchangeRate.getMathematicOperatorCode();
	}

	@Override
	public void setMathematicOperatorCode(String value) {
		this.exchangeRate.setMathematicOperatorCode(value);
	}

	@Override
	public LocalDate getDate() {
		return this.exchangeRate.getDate();
	}

	@Override
	public void setDate(LocalDate value) {
		this.exchangeRate.setDate(value);
	}

	@Override
	public ContractModel getForeignExchangeContract() {
		return new ContractAdapter(session, em, exchangeRate.getForeignExchangeContract());
	}

	@Override
	public void setForeignExchangeContract(ContractModel value) {
		this.exchangeRate.setForeignExchangeContract(ContractAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return this.exchangeRate.getId();
	}

	@Override
	public void setId(String value) {
		this.exchangeRate.setId(value);
	}

	@Override
	public ExchangeRateEntity getEntity() {
		return exchangeRate;
	}

}
