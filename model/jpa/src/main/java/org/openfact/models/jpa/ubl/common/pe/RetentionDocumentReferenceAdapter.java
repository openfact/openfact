package org.openfact.models.jpa.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.pe.RetentionDocumentReferenceEntity;
import org.openfact.models.jpa.ubl.common.PaymentAdapter;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.pe.RetentionDocumentReferenceModel;
import org.openfact.models.ubl.common.pe.RetentionInformationModel;

public class RetentionDocumentReferenceAdapter
		implements RetentionDocumentReferenceModel, JpaModel<RetentionDocumentReferenceEntity> {

	protected static final Logger logger = Logger.getLogger(RetentionDocumentReferenceAdapter.class);

	protected RetentionDocumentReferenceEntity retentionDocumentReference;
	protected EntityManager em;
	protected OpenfactSession session;

	public RetentionDocumentReferenceAdapter(OpenfactSession session, EntityManager em,
			RetentionDocumentReferenceEntity retentionDocumentReference) {
		this.session = session;
		this.em = em;
		this.retentionDocumentReference = retentionDocumentReference;
	}

	@Override
	public RetentionDocumentReferenceEntity getEntity() {
		return retentionDocumentReference;
	}

	@Override
	public String getId() {
		return retentionDocumentReference.getId();
	}

	@Override
	public String getID() {
		return retentionDocumentReference.getID();
	}

	@Override
	public void setID(String iD) {
		retentionDocumentReference.setID(iD);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return retentionDocumentReference.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		retentionDocumentReference.setIssueDateTime(issueDateTime);
	}

	@Override
	public BigDecimal getTotalInvoiceAmount() {
		return retentionDocumentReference.getTotalInvoiceAmount();
	}

	@Override
	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		retentionDocumentReference.setTotalInvoiceAmount(totalInvoiceAmount);
	}

	@Override
	public PaymentModel getPayment() {
		return new PaymentAdapter(session, em, retentionDocumentReference.getPayment());
	}

	@Override
	public void setPayment(PaymentModel payment) {
		retentionDocumentReference.setPayment(PaymentAdapter.toEntity(payment, em));
	}

	@Override
	public RetentionInformationModel getSunatRetentionInformation() {
		return new RetentionInformationAdapter(session, em, retentionDocumentReference.getSunatRetentionInformation());
	}

	@Override
	public void setSunatRetentionInformation(RetentionInformationModel sunatRetentionInformation) {
		retentionDocumentReference
				.setSunatRetentionInformation(RetentionInformationAdapter.toEntity(sunatRetentionInformation, em));
	}

	public static RetentionDocumentReferenceEntity toEntity(RetentionDocumentReferenceModel model, EntityManager em) {
		if (model instanceof RetentionDocumentReferenceAdapter) {
			return ((RetentionDocumentReferenceAdapter) model).getEntity();
		}
		return em.getReference(RetentionDocumentReferenceEntity.class, model.getId());
	}

}
