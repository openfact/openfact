package org.openfact.models.jpa;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.models.CustomerModel;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.InvoiceAdditionalInformationModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;
import org.openfact.models.jpa.entities.InvoiceAdditionalInformationEntity;
import org.openfact.models.jpa.entities.InvoiceAttributeEntity;
import org.openfact.models.jpa.entities.InvoiceEntityDEPRECATED;
import org.openfact.models.jpa.entities.InvoiceLineEntityDEPRECATED;
import org.openfact.models.jpa.entities.InvoiceRequiredActionEntity;
import org.openfact.models.jpa.entities.InvoiceTaxTotalEntity;
import org.openfact.ubl.UblException;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntityDEPRECATED> {

	protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

	protected OrganizationModel organization;
	protected InvoiceEntityDEPRECATED invoice;
	protected EntityManager em;
	protected OpenfactSession session;

	public InvoiceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			InvoiceEntityDEPRECATED invoice) {
		this.session = session;
		this.em = em;
		this.organization = organization;
		this.invoice = invoice;
	}

	@Override
	public InvoiceEntityDEPRECATED getEntity() {
		return invoice;
	}

	public static InvoiceEntityDEPRECATED toEntity(InvoiceModel model, EntityManager em) {
		if (model instanceof InvoiceAdapter) {
			return ((InvoiceAdapter) model).getEntity();
		}
		return em.getReference(InvoiceEntityDEPRECATED.class, model.getId());
	}

	@Override
	public String getId() {
		return invoice.getId();
	}

	@Override
	public int getSeries() {
		return invoice.getSeries();
	}

	@Override
	public void setSeries(int series) {
		invoice.setSeries(series);
	}

	@Override
	public int getNumber() {
		return invoice.getNumber();
	}

	@Override
	public void setNumber(int number) {
		invoice.setNumber(number);
	}
	
    @Override
    public String getSeriesAndNumberAsId() {
        StringBuilder sb = new StringBuilder();
        sb.append(invoice.getType().getName().charAt(0));
        sb.append(invoice.getSeries());
        sb.append("-");
        sb.append(invoice.getNumber());
        return null;
    }
	
    @Override
    public String getTypeName() {
        if(invoice.getType() != null) {
            return invoice.getType().getName();    
        }
        return null;
    }

    @Override
    public void setTypeName(String typeName) {
        if(invoice.getType() != null) {
            invoice.getType().setName(typeName); 
        } else {
            DocumentSnapshotEntity document = new DocumentSnapshotEntity();
            document.setName(typeName);
            invoice.setType(document);
        }        
    }

    @Override
    public String getTypeId() {
        if(invoice.getType() != null) {
            return invoice.getType().getDocumentId();   
        }
        return null;
    }

    @Override
    public void setTypeId(String typeId) {
        if(invoice.getType() != null) {
            invoice.getType().setDocumentId(typeId); 
        } else {
            DocumentSnapshotEntity document = new DocumentSnapshotEntity();
            document.setDocumentId(typeId);
            invoice.setType(document);
        }        
    }

	@Override
	public LocalDate getIssueDate() {
		return invoice.getIssueDate();
	}

	@Override
	public void setIssueDate(LocalDate issueDate) {
		invoice.setIssueDate(issueDate);
	}

	@Override
	public String getCurrencyCode() {
		return invoice.getCurrencyCode();
	}

	@Override
	public void setCurrencyCode(String currencyCode) {
		invoice.setCurrencyCode(currencyCode);
	}

	@Override
	public BigDecimal getAllowanceTotalAmount() {
		return invoice.getAllowanceTotalAmount();
	}

	@Override
	public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
		invoice.setAllowanceTotalAmount(allowanceTotalAmount);
	}

	@Override
	public BigDecimal getChargeTotalAmount() {
		return invoice.getChargeTotalAmount();
	}

	@Override
	public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
		invoice.setChargeTotalAmount(chargeTotalAmount);
	}

	@Override
	public BigDecimal getPayableAmount() {
		return invoice.getPayableAmount();
	}

	@Override
	public void setPayableAmount(BigDecimal payableAmount) {
		invoice.setPayableAmount(payableAmount);
	}

	@Override
	public CustomerModel getCustomer() {
		return new CustomerAdapter(session, this, em, invoice.getCustomer());
	}

	@Override
	public void setCustomer(CustomerModel customer) {
		CustomerEntity customerEntity = CustomerAdapter.toEntity(customer, em);
		invoice.setCustomer(customerEntity);
	}

	@Override
	public Set<InvoiceAdditionalInformationModel> getAdditionalInformation() {
        return invoice.getAdditionalInformation().stream()
                .map(f -> new InvoiceAdditionalInformationAdapter(session, this, em, f))
                .collect(Collectors.toSet());
	}

	@Override
	public InvoiceAdditionalInformationModel addAdditionalInformation(String name, String id, BigDecimal amount) {
		DocumentSnapshotEntity document = new DocumentSnapshotEntity();
		document.setName(name);
		document.setDocumentId(id);

		InvoiceAdditionalInformationEntity entity = new InvoiceAdditionalInformationEntity();
		entity.setAmmount(amount);
		entity.setDocument(document);
		entity.setInvoice(invoice);		

		em.persist(entity);
		em.flush();

		invoice.getAdditionalInformation().add(entity);
		return new InvoiceAdditionalInformationAdapter(session, this, em, entity);
	}

	@Override
	public Set<InvoiceTaxTotalModel> getInvoiceTaxTotal() {
        return invoice.getTaxTotals().stream().map(f -> new InvoiceTaxTotalAdapter(session, this, em, f))
                .collect(Collectors.toSet());
	}

	@Override
	public InvoiceTaxTotalModel addTaxTotal(String name, String id, BigDecimal taxAmount, BigDecimal taxValue) {
		DocumentSnapshotEntity document = new DocumentSnapshotEntity();
		document.setName(name);
		document.setDocumentId(id);

		InvoiceTaxTotalEntity taxTotalEntity = new InvoiceTaxTotalEntity();
		taxTotalEntity.setAmount(taxAmount);
		taxTotalEntity.setValue(taxValue);
		taxTotalEntity.setDocument(document);
		taxTotalEntity.setInvoice(invoice);

		em.persist(taxTotalEntity);
		em.flush();

		invoice.getTaxTotals().add(taxTotalEntity);
		return new InvoiceTaxTotalAdapter(session, this, em, taxTotalEntity);
	}

	@Override
	public List<InvoiceLineModel> getInvoiceLines() {
		List<InvoiceLineModel> invoiceLines = new ArrayList<>();
		List<InvoiceLineEntityDEPRECATED> entities = invoice.getInvoiceLines();
		entities.forEach(f -> invoiceLines.add(new InvoiceLineAdapter(session, this, em, f)));
		return invoiceLines;
	}

	@Override
	public InvoiceLineModel addInvoiceLine() {
		InvoiceLineEntityDEPRECATED entity = new InvoiceLineEntityDEPRECATED();
		entity.setInvoice(invoice);
		em.persist(entity);
		em.flush();
		final InvoiceLineModel adapter = new InvoiceLineAdapter(session, this, em, entity);
		return adapter;
	}

	@Override
	public boolean removeInvoiceLine(InvoiceLineModel invoiceLine) {
		if (invoiceLine == null) {
			return false;
		}

		InvoiceLineEntityDEPRECATED invoiceLineEntity = null;
		Iterator<InvoiceLineEntityDEPRECATED> it = invoice.getInvoiceLines().iterator();
		while (it.hasNext()) {
			InvoiceLineEntityDEPRECATED ae = it.next();
			if (ae.equals(invoiceLine)) {
				invoiceLineEntity = ae;
				it.remove();
				break;
			}
		}
		if (invoiceLineEntity == null) {
			return false;
		}

		em.remove(invoiceLineEntity);
		em.flush();
		return true;
	}

    @Override
    public Document getUbl() {
        String ublRepresentation = invoice.getUblRepresentation();
        if(ublRepresentation == null) {
            return null;
        }        
        return session.getProvider(UblProvider.class).getDocument(ublRepresentation);
    }

    @Override
    public void setUbl(Document ubl) {
        try {
            DOMSource domSource = new DOMSource(ubl);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, result);
            writer.flush();

            invoice.setUblRepresentation(writer.toString());
        } catch (TransformerException e) {
            throw new ModelException("Invalid document sended");
        }
    }

	@Override
	public OrganizationModel getOrganization() {
		return organization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceAdapter other = (InvoiceAdapter) obj;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		return true;
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		boolean found = false;
		List<InvoiceAttributeEntity> toRemove = new ArrayList<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				if (!found) {
					attr.setValue(value);
					found = true;
				} else {
					toRemove.add(attr);
				}
			}
		}

		for (InvoiceAttributeEntity attr : toRemove) {
			em.remove(attr);
			invoice.getAttributes().remove(attr);
		}

		if (found) {
			return;
		}

		persistAttributeValue(name, value);

	}

	@Override
	public void setAttribute(String name, List<String> values) {
		// Remove all existing
		removeAttribute(name);

		// Put all new
		for (String value : values) {
			persistAttributeValue(name, value);
		}
	}

	private void persistAttributeValue(String name, String value) {
		InvoiceAttributeEntity attr = new InvoiceAttributeEntity();
		attr.setName(name);
		attr.setValue(value);
		attr.setInvoice(invoice);
		em.persist(attr);
		invoice.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// KEYCLOAK-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteInvoiceAttributesByNameAndInvoice");
		query.setParameter("name", name);
		query.setParameter("invoiceId", invoice.getId());
		int numUpdated = query.executeUpdate();
	}

	@Override
	public String getFirstAttribute(String name) {
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public Set<String> getRequiredActions() {
		Set<String> result = new HashSet<>();
		for (InvoiceRequiredActionEntity attr : invoice.getRequiredActions()) {
			result.add(attr.getAction());
		}
		return result;
	}

	@Override
	public void addRequiredAction(RequiredAction action) {
		String actionName = action.name();
		addRequiredAction(actionName);
	}

	@Override
	public void addRequiredAction(String actionName) {
		for (InvoiceRequiredActionEntity attr : invoice.getRequiredActions()) {
			if (attr.getAction().equals(actionName)) {
				return;
			}
		}
		InvoiceRequiredActionEntity attr = new InvoiceRequiredActionEntity();
		attr.setAction(actionName);
		attr.setInvoice(invoice);
		em.persist(attr);
		invoice.getRequiredActions().add(attr);
	}

	@Override
	public void removeRequiredAction(String actionName) {
		Iterator<InvoiceRequiredActionEntity> it = invoice.getRequiredActions().iterator();
		while (it.hasNext()) {
			InvoiceRequiredActionEntity attr = it.next();
			if (attr.getAction().equals(actionName)) {
				it.remove();
				em.remove(attr);
			}
		}
	}

	@Override
	public void removeRequiredAction(RequiredAction action) {
		String actionName = action.name();
		removeRequiredAction(actionName);
	}
	
	@Override
    public long getCreatedTimestamp() {
        return invoice.getCreatedTimestamp();
    }

}
