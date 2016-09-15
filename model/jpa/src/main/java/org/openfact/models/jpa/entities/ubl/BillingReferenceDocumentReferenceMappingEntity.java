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
@Table(name = "BILLING_REFERENCE_DOCUMENT_REFERENCE_MAPPING")
@IdClass(BillingReferenceDocumentReferenceMappingEntity.Key.class)
public class BillingReferenceDocumentReferenceMappingEntity {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BILLING_REFERENCE_ID")
	protected BillingReferenceEntity billingReference;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUMENT_REFERENCE_ID")
	protected DocumentReferenceEntity documentReference;

	/**
	 * @return the billingReference
	 */
	public BillingReferenceEntity getBillingReference() {
		return billingReference;
	}

	/**
	 * @param billingReference
	 *            the billingReference to set
	 */
	public void setBillingReference(BillingReferenceEntity billingReference) {
		this.billingReference = billingReference;
	}

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

	public static class Key implements Serializable {

		protected BillingReferenceEntity billingReference;

		protected DocumentReferenceEntity documentReference;

		public Key() {

		}

		public Key(BillingReferenceEntity billingReference, DocumentReferenceEntity documentReference) {
			super();
			this.billingReference = billingReference;
			this.documentReference = documentReference;
		}

		/**
		 * @return the billingReference
		 */
		public BillingReferenceEntity getBillingReference() {
			return billingReference;
		}

		/**
		 * @return the documentReference
		 */
		public DocumentReferenceEntity getDocumentReference() {
			return documentReference;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Key key = (Key) o;

			if (billingReference != null
					? !billingReference.getId()
							.equals(key.billingReference != null ? key.billingReference.getId() : null)
					: key.billingReference != null)
				return false;
			if (documentReference != null
					? !documentReference.getId()
							.equals(key.documentReference != null ? key.documentReference.getId() : null)
					: key.documentReference != null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = billingReference != null ? billingReference.getId().hashCode() : 0;
			result = 31 * result + (documentReference != null ? documentReference.getId().hashCode() : 0);
			return result;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof BillingReferenceDocumentReferenceMappingEntity))
			return false;

		BillingReferenceDocumentReferenceMappingEntity key = (BillingReferenceDocumentReferenceMappingEntity) o;

		if (billingReference != null
				? !billingReference.getId().equals(key.billingReference != null ? key.billingReference.getId() : null)
				: key.billingReference != null)
			return false;
		if (documentReference != null
				? !documentReference.getId()
						.equals(key.documentReference != null ? key.documentReference.getId() : null)
				: key.documentReference != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = billingReference != null ? billingReference.getId().hashCode() : 0;
		result = 31 * result + (documentReference != null ? documentReference.getId().hashCode() : 0);
		return result;
	}
}
