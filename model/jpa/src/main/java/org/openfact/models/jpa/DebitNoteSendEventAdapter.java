package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.DebitNoteSendEventEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class DebitNoteSendEventAdapter implements DebitNoteSendEventModel, JpaModel<DebitNoteSendEventEntity> {
	protected static final Logger logger = Logger.getLogger(DebitNoteSendEventAdapter.class);

	protected OrganizationModel organization;
	protected DebitNoteSendEventEntity debitNoteSendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public DebitNoteSendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			DebitNoteSendEventEntity debitNoteSendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.debitNoteSendEvent = debitNoteSendEvent;
	}

	@Override
	public String getId() {
		return debitNoteSendEvent.getId();
	}

	@Override
	public boolean getResult() {
		return debitNoteSendEvent.isResult();
	}

	@Override
	public void setResult(boolean result) {
		debitNoteSendEvent.setResult(result);
	}

	@Override
	public String getDescription() {
		return debitNoteSendEvent.getDescription();
	}

	@Override
	public void setDescription(String description) {
		debitNoteSendEvent.setDescription(description);
	}

	@Override
	public OrganizationModel getOrganization() {
		if (debitNoteSendEvent.getOrganization() == null) {
			return null;
		}
		return new OrganizationAdapter(session, em, debitNoteSendEvent.getOrganization());
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public void setType(String type) {

	}

	@Override
	public Map<String, String> getDestity() {
		return null;
	}

	@Override
	public void setDestiny(Map<String, String> destiny) {

	}

	@Override
	public LocalDateTime getCreatedTimestamp() {
		return null;
	}

	@Override
	public DebitNoteSendEventEntity getEntity() {
		return debitNoteSendEvent;
	}

	@Override
	public DebitNoteModel getDebitNote() {
		if (debitNoteSendEvent.getDebitNote() == null) {
			return null;
		}
		return new DebitNoteAdapter(session, organization, em, debitNoteSendEvent.getDebitNote());
	}

	@Override
	public void setDebitNote(DebitNoteModel debitNote) {
		debitNoteSendEvent.setDebitNote(DebitNoteAdapter.toEntity(debitNote, em));
	}

	public static DebitNoteSendEventEntity toEntity(DebitNoteSendEventModel model, EntityManager em) {
		if (model instanceof DebitNoteSendEventAdapter) {
			return ((DebitNoteSendEventAdapter) model).getEntity();
		}
		return em.getReference(DebitNoteSendEventEntity.class, model.getId());
	}

    @Override
    public StorageFileModel addFileAttatchments(FileModel file) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<StorageFileModel> getFileAttatchments() {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public List<StorageFileModel> getFileResponseAttatchments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageFileModel addFileResponseAttatchments(FileModel file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResponse(Map<String, String> response) {
		// TODO Auto-generated method stub
		
	}
}
