package org.openfact.models.jpa.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.pe.PerceptionDocumentReferenceEntity;
import org.openfact.models.jpa.ubl.common.PaymentAdapter;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.pe.PerceptionDocumentReferenceModel;
import org.openfact.models.ubl.common.pe.PerceptionInformationModel;

public class PerceptionDocumentReferenceAdapter
		implements PerceptionDocumentReferenceModel, JpaModel<PerceptionDocumentReferenceEntity> {

	protected static final Logger logger = Logger.getLogger(PerceptionDocumentReferenceAdapter.class);

	protected PerceptionDocumentReferenceEntity perceptionDocumentReference;
	protected EntityManager em;
	protected OpenfactSession session;

	public PerceptionDocumentReferenceAdapter(OpenfactSession session, EntityManager em,
			PerceptionDocumentReferenceEntity perceptionDocumentReference) {
		this.session = session;
		this.em = em;
		this.perceptionDocumentReference = perceptionDocumentReference;
	}

	@Override
	public PerceptionDocumentReferenceEntity getEntity() {
		return perceptionDocumentReference;
	}

	@Override
	public String getId() {
		return perceptionDocumentReference.getId();
	}

	@Override
	public String getID() {
		return perceptionDocumentReference.getID();
	}

	@Override
	public void setID(String iD) {
		perceptionDocumentReference.setID(iD);
	}

	@Override
	public LocalDateTime getIssueDateTime() {
		return perceptionDocumentReference.getIssueDateTime();
	}

	@Override
	public void setIssueDateTime(LocalDateTime issueDateTime) {
		perceptionDocumentReference.setIssueDateTime(issueDateTime);
	}

	@Override
	public BigDecimal getTotalInvoiceAmount() {
		return perceptionDocumentReference.getTotalInvoiceAmount();
	}

	@Override
	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		perceptionDocumentReference.setTotalInvoiceAmount(totalInvoiceAmount);
	}

	@Override
	public PaymentModel getPayment() {
		return new PaymentAdapter(session, em, perceptionDocumentReference.getPayment());
	}

	@Override
	public void setPayment(PaymentModel payment) {
		perceptionDocumentReference.setPayment(PaymentAdapter.toEntity(payment, em));
	}

	@Override
	public PerceptionInformationModel getSunatPerceptionInformation() {
		return new PerceptionInformationAdapter(session, em,
				perceptionDocumentReference.getSunatPerceptionInformation());
	}

	@Override
	public void setSunatPerceptionInformation(PerceptionInformationModel sunatPerceptionInformation) {
		perceptionDocumentReference
				.setSunatPerceptionInformation(PerceptionInformationAdapter.toEntity(sunatPerceptionInformation, em));
	}

	public static PerceptionDocumentReferenceEntity toEntity(PerceptionDocumentReferenceModel model, EntityManager em) {
		if (model instanceof PerceptionDocumentReferenceAdapter) {
			return ((PerceptionDocumentReferenceAdapter) model).getEntity();
		}
		return em.getReference(PerceptionDocumentReferenceEntity.class, model.getId());
	}

}
