package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "SEND_EVENT")
@NamedQueries({
		@NamedQuery(name = "getAllSendEventsByInvoice", query = "select i from SendEventEntity i join i.invoices a where a.id = :invoiceId order by i.createdTimestamp"),
		@NamedQuery(name = "getAllSendEventsByDebitNote", query = "select i from SendEventEntity i join i.debitNotes a where a.id = :debitNoteId order by i.createdTimestamp"),
		@NamedQuery(name = "getAllSendEventsByCreditNote", query = "select i from SendEventEntity i join i.creditNotes a where a.id = :creditNoteId order by i.createdTimestamp") })
public class SendEventEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;

	@ManyToMany(cascade = { CascadeType.ALL })
	protected List<InvoiceEntity> invoices = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.ALL })
	protected List<DebitNoteEntity> debitNotes = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.ALL })
	protected List<CreditNoteEntity> creditNotes = new ArrayList<>();

	@Lob
	@Column(name = "XML_DOCUMENT")
	protected byte[] xmlDocument;

	@Lob
	@Column(name = "EVENT_DOCUMENT")
	protected byte[] eventDocument;

	@Column(name = "IS_ERROR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean isError;

	@ElementCollection
	@MapKeyColumn(name = "NAME")
	@Column(name = "VALUE")
	@CollectionTable(name = "SEND_WARNING", joinColumns = { @JoinColumn(name = "SEND_EVENT_ID") })
	private Map<String, String> sendWarning = new HashMap<String, String>();

	@Type(type = "org.hibernate.type.LocalDateTimeType")
	@Column(name = "CREATED_TIMESTAMP")
	private LocalDateTime createdTimestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getXmlDocument() {
		return xmlDocument;
	}

	public void setXmlDocument(byte[] xmlDocument) {
		this.xmlDocument = xmlDocument;
	}

	public byte[] getEventDocument() {
		return eventDocument;
	}

	public void setEventDocument(byte[] eventDocument) {
		this.eventDocument = eventDocument;
	}

	public Map<String, String> getSendWarning() {
		return sendWarning;
	}

	public void setSendWarning(Map<String, String> sendWarning) {
		this.sendWarning = sendWarning;
	}

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public List<InvoiceEntity> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<InvoiceEntity> invoices) {
		this.invoices = invoices;
	}

	public List<DebitNoteEntity> getDebitNotes() {
		return debitNotes;
	}

	public void setDebitNotes(List<DebitNoteEntity> debitNotes) {
		this.debitNotes = debitNotes;
	}

	public List<CreditNoteEntity> getCreditNotes() {
		return creditNotes;
	}

	public void setCreditNotes(List<CreditNoteEntity> creditNotes) {
		this.creditNotes = creditNotes;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

}
