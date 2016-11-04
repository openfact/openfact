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
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;
import org.openfact.models.jpa.entities.ubl.common.SummaryDocumentsLineEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.SummaryDocumentsLineModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class SummaryDocumentsLineAdapter implements SummaryDocumentsLineModel, JpaModel<SummaryDocumentsLineEntity> {
	protected static final Logger logger = Logger.getLogger(SummaryDocumentsLineAdapter.class);

	protected SummaryDocumentsLineEntity summaryDocumentsLine;
	protected EntityManager em;
	protected OpenfactSession session;

	public SummaryDocumentsLineAdapter(OpenfactSession session, EntityManager em,
			SummaryDocumentsLineEntity summaryDocumentsLine) {
		this.session = session;
		this.em = em;
		this.summaryDocumentsLine = summaryDocumentsLine;
	}

	@Override
	public SummaryDocumentsLineEntity getEntity() {
		return summaryDocumentsLine;
	}

	@Override
	public String getLineID() {
		return summaryDocumentsLine.getLineID();
	}

	@Override
	public void setLineID(String value) {
		summaryDocumentsLine.setLineID(value);
	}

	@Override
	public String getDocumentTypeCode() {
		return summaryDocumentsLine.getDocumentTypeCode();
	}

	@Override
	public void setDocumentTypeCode(String value) {
		summaryDocumentsLine.setDocumentTypeCode(value);
	}

	@Override
	public String getDocumentSerialID() {
		return summaryDocumentsLine.getDocumentSerialID();
	}

	@Override
	public void setDocumentSerialID(String value) {
		summaryDocumentsLine.setDocumentSerialID(value);
	}

	@Override
	public String getStartDocumentNumberID() {
		return summaryDocumentsLine.getStartDocumentNumberID();
	}

	@Override
	public void setStartDocumentNumberID(String value) {
		summaryDocumentsLine.setStartDocumentNumberID(value);
	}

	@Override
	public String getEndDocumentNumberID() {
		return summaryDocumentsLine.getEndDocumentNumberID();
	}

	@Override
	public void setEndDocumentNumberID(String value) {
		summaryDocumentsLine.setEndDocumentNumberID(value);
	}

	@Override
	public BigDecimal getTotalAmount() {
		return summaryDocumentsLine.getTotalAmount();
	}

	@Override
	public void setTotalAmount(BigDecimal value) {
		summaryDocumentsLine.setTotalAmount(value);
	}

	@Override
	public List<PaymentModel> getBillingPayment() {
		return summaryDocumentsLine.getBillingPayment().stream().map(f -> new PaymentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setBillingPayment(List<PaymentModel> billingPayment) {
		List<PaymentEntity> entities = billingPayment.stream().map(f -> PaymentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		summaryDocumentsLine.setBillingPayment(entities);
	}

	@Override
	public List<AllowanceChargeModel> getAllowanceCharge() {
		return summaryDocumentsLine.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
		List<AllowanceChargeEntity> entities = allowanceCharge.stream().map(f -> AllowanceChargeAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		summaryDocumentsLine.setAllowanceCharge(entities);
	}

	@Override
	public List<TaxTotalModel> getTaxTotal() {
		return summaryDocumentsLine.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setTaxTotal(List<TaxTotalModel> taxTotal) {
		List<TaxTotalEntity> entities = taxTotal.stream().map(f -> TaxTotalAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		summaryDocumentsLine.setTaxTotal(entities);
	}

	@Override
	public String getId() {
		return summaryDocumentsLine.getId();
	}
	public static SummaryDocumentsLineEntity toEntity(SummaryDocumentsLineModel model, EntityManager em) {
		if (model instanceof SummaryDocumentsLineAdapter) {
			return ((SummaryDocumentsLineAdapter) model).getEntity();
		}
		return em.getReference(SummaryDocumentsLineEntity.class, model.getId());
	}

}
