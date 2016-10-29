package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.jpa.entities.ubl.common.StatusEntity;
import org.openfact.models.jpa.entities.ubl.pe.DespatchAdviceEntity;
import org.openfact.models.jpa.ubl.pe.DespatchAdviceAdapter;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.StatusModel;

public class StatusAdapter implements StatusModel, JpaModel<StatusEntity> {

	protected static final Logger logger = Logger.getLogger(StatusAdapter.class);

	protected StatusEntity status;
	protected EntityManager em;
	protected OpenfactSession session;

	public StatusAdapter(OpenfactSession session, EntityManager em, StatusEntity status) {
		this.session = session;
		this.em = em;
		this.status = status;
	}

	@Override
	public StatusEntity getEntity() {
		return status;
	}

	@Override
	public String getConditionCode() {
		return status.getConditionCode();
	}

	@Override
	public void setConditionCode(String value) {
		status.setConditionCode(value);
	}

	@Override
	public LocalDate getReferenceDate() {
		return status.getReferenceDate();
	}

	@Override
	public void setReferenceDate(LocalDate value) {
		status.setReferenceDate(value);
	}

	@Override
	public LocalTime getReferenceTime() {
		return status.getReferenceTime();
	}

	@Override
	public void setReferenceTime(LocalTime value) {
		status.setReferenceTime(value);
	}

	@Override
	public String getDescription() {
		return status.getDescription();
	}

	@Override
	public void setDescription(String value) {
		status.setDescription(value);
	}

	@Override
	public String getStatusReasonCode() {
		return status.getStatusReasonCode();
	}

	@Override
	public void setStatusReasonCode(String value) {
		status.setStatusReasonCode(value);
	}

	@Override
	public String getStatusReason() {
		return status.getStatusReason();
	}

	@Override
	public void setStatusReason(String value) {
		status.setStatusReason(value);
	}

	@Override
	public String getSequenceID() {
		return status.getSequenceID();
	}

	@Override
	public void setSequenceID(String value) {
		status.setSequenceID(value);
	}

	@Override
	public String getText() {
		return status.getText();
	}

	@Override
	public void setText(String value) {
		status.setText(value);
	}

	@Override
	public boolean getIndicationIndicator() {
		return status.isIndicationIndicator();
	}

	@Override
	public void setIndicationIndicator(boolean value) {
		status.setIndicationIndicator(value);
	}

	@Override
	public BigDecimal getPercent() {
		return status.getPercent();
	}

	@Override
	public void setPercent(BigDecimal value) {
		status.setPercent(value);
	}

	@Override
	public String getId() {
		return status.getId();
	}

	public static StatusEntity toEntity(StatusModel model, EntityManager em) {
		if (model instanceof StatusAdapter) {
			return ((StatusAdapter) model).getEntity();
		}
		return em.getReference(StatusEntity.class, model.getId());
	}
}
