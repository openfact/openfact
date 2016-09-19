package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.PriceEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.PriceListModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.QuantityModel;

public class PriceAdapter implements PriceModel, JpaModel<PriceEntity> {

	protected static final Logger logger = Logger.getLogger(PriceAdapter.class);
	protected PriceEntity price;
	protected EntityManager em;
	protected OpenfactSession session;

	public PriceAdapter(OpenfactSession session, EntityManager em, PriceEntity price) {
		this.session = session;
		this.em = em;
		this.price = price;
	}

	@Override
	public BigDecimal getPriceAmount() {
		return this.price.getPriceAmount();
	}

	@Override
	public void setPriceAmount(BigDecimal value) {
		this.price.setPriceAmount(value);
	}

	@Override
	public QuantityModel getBaseQuantity() {
		return new QuantityAdapter(session, em, price.getBaseQuantity());
	}

	@Override
	public void setBaseQuantity(QuantityModel value) {
		this.price.setBaseQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public List<String> getPriceChangeReason() {
		return this.price.getPriceChangeReason();
	}

	@Override
	public void setPriceChangeReason(List<String> priceChangeReason) {
		this.price.setPriceChangeReason(priceChangeReason);
	}

	@Override
	public String getPriceTypeCode() {
		return this.price.getPriceTypeCode();
	}

	@Override
	public void setPriceTypeCode(String value) {
		this.price.setPriceTypeCode(value);
	}

	@Override
	public String getPriceType() {
		return this.price.getPriceType();
	}

	@Override
	public void setPriceType(String value) {
		this.price.setPriceType(value);
	}

	@Override
	public BigDecimal getOrderableUnitFactorRate() {
		return this.price.getOrderableUnitFactorRate();
	}

	@Override
	public void setOrderableUnitFactorRate(BigDecimal value) {
		this.price.setOrderableUnitFactorRate(value);
	}

	@Override
	public List<PeriodModel> getValidityPeriod() {
		return price.getValidityPeriod().stream().map(f -> new PeriodAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setValidityPeriod(List<PeriodModel> validityPeriod) {
		List<PeriodEntity> entities = validityPeriod.stream().map(f -> PeriodAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		this.price.setValidityPeriod(entities);
	}

	@Override
	public PriceListModel getPriceList() {
		return new PriceListAdapter(session, em, price.getPriceList());
	}

	@Override
	public void setPriceList(PriceListModel value) {
		this.price.setPriceList(PriceListAdapter.toEntity(value, em));
	}

	@Override
	public List<AllowanceChargeModel> getAllowanceCharge() {
		return price.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
		List<AllowanceChargeEntity> entities = allowanceCharge.stream().map(f -> AllowanceChargeAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		this.price.setAllowanceCharge(entities);
	}

	@Override
	public String getId() {
		return this.price.getId();
	}

	@Override
	public void setId(String value) {
		this.price.setId(value);
	}

	public static PriceEntity toEntity(PriceModel model, EntityManager em) {
		if (model instanceof PriceModel) {
            return ((PriceAdapter) model).getEntity();
        }
        return em.getReference(PriceEntity.class, model.getId());
	}

	@Override
	public PriceEntity getEntity() {
		return price;
	}

}
