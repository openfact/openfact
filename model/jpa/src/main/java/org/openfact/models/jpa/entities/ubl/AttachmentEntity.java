package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.BinaryObjectType;

/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
@Entity
@Table(name = "ATTACHMENT")
public class AttachmentEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * A binary large object containing an attached document.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "EMBEDDEDDOCUMENTBINARYOBJECT_VALUE")),
			@AttributeOverride(name = "format", column = @Column(name = "EMBEDDEDDOCUMENTBINARYOBJECT_FORMAT")),
			@AttributeOverride(name = "encodingCode", column = @Column(name = "EMBEDDEDDOCUMENTBINARYOBJECT_ENCODINGCODE")),
			@AttributeOverride(name = "characterSetCode", column = @Column(name = "EMBEDDEDDOCUMENTBINARYOBJECT_CHARACTERSETCODE")),
			@AttributeOverride(name = "uri", column = @Column(name = "EMBEDDEDDOCUMENTBINARYOBJECT_URI")),
			@AttributeOverride(name = "filename", column = @Column(name = "EMBEDDEDDOCUMENTBINARYOBJECT_FILENAME")) })
	private BinaryObjectType embeddedDocumentBinaryObject;

	@OneToMany(mappedBy = "attachment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<ExternalReferenceEntity> externalReferences = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "SIGNATURE_ID")
	private SignatureEntity signature;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the embeddedDocumentBinaryObject
	 */
	public BinaryObjectType getEmbeddedDocumentBinaryObject() {
		return embeddedDocumentBinaryObject;
	}

	/**
	 * @param embeddedDocumentBinaryObject the embeddedDocumentBinaryObject to set
	 */
	public void setEmbeddedDocumentBinaryObject(BinaryObjectType embeddedDocumentBinaryObject) {
		this.embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
	}

	/**
	 * @return the externalReferences
	 */
	public List<ExternalReferenceEntity> getExternalReferences() {
		return externalReferences;
	}

	/**
	 * @param externalReferences the externalReferences to set
	 */
	public void setExternalReferences(List<ExternalReferenceEntity> externalReferences) {
		this.externalReferences = externalReferences;
	}

	/**
	 * @return the signature
	 */
	public SignatureEntity getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(SignatureEntity signature) {
		this.signature = signature;
	}
	

}
