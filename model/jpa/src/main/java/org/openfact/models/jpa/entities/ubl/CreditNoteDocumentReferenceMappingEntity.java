package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_NOTE_DOCUMENT_REFERENCE_MAPPING")
@IdClass(CreditNoteDocumentReferenceMappingEntity.Key.class)
public class CreditNoteDocumentReferenceMappingEntity {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	protected CreditNoteEntity creditNote;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUMENT_REFERENCE_ID")
	protected DocumentReferenceEntity documentReference;

	/**
	 * @return the documentReference
	 */
	public DocumentReferenceEntity getDocumentReference() {
		return documentReference;
	}

	/**
	 * @param documentReference
	 *            the documentReference to set
	 */
	public void setDocumentReference(DocumentReferenceEntity documentReference) {
		this.documentReference = documentReference;
	}

	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote
	 *            the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}

	public static class Key implements Serializable {

		protected DocumentReferenceEntity documentReference;

		protected CreditNoteEntity creditNote;

		public Key() {

		}

		public Key(DocumentReferenceEntity documentReference, CreditNoteEntity creditNote) {
			super();
			this.documentReference = documentReference;
			this.creditNote = creditNote;
		}

		/**
		 * @return the documentReference
		 */
		public DocumentReferenceEntity getDocumentReference() {
			return documentReference;
		}

		/**
		 * @return the creditNote
		 */
		public CreditNoteEntity getCreditNote() {
			return creditNote;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (documentReference != null
					? !documentReference.getId()
							.equals(key.documentReference != null ? key.documentReference.getId() : null)
					: key.documentReference != null)
				return false;
			if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
					: key.creditNote != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = documentReference != null ? documentReference.getId().hashCode() : 0;
			result = 31 * result + (creditNote != null ? creditNote.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CreditNoteDocumentReferenceMappingEntity))
			return false;

		CreditNoteDocumentReferenceMappingEntity key = (CreditNoteDocumentReferenceMappingEntity) o;

		if (documentReference != null
				? !documentReference.getId()
						.equals(key.documentReference != null ? key.documentReference.getId() : null)
				: key.documentReference != null)
			return false;
		if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null)
				: key.creditNote != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = documentReference != null ? documentReference.getId().hashCode() : 0;
		result = 31 * result + (creditNote != null ? creditNote.getId().hashCode() : 0);
		return result;
	}
}
