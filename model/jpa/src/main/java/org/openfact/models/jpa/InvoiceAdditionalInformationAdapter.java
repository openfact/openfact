package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSavedModel;
import org.openfact.models.InvoiceAdditionalInformationModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.DocumentSavedEntity;
import org.openfact.models.jpa.entities.InvoiceAdditionalInformationEntity;

public class InvoiceAdditionalInformationAdapter
        implements InvoiceAdditionalInformationModel, JpaModel<InvoiceAdditionalInformationEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdditionalInformationAdapter.class);

    protected InvoiceModel invoice;
    protected InvoiceAdditionalInformationEntity additionalInformation;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceAdditionalInformationAdapter(OpenfactSession session, InvoiceModel invoice,
            EntityManager em, InvoiceAdditionalInformationEntity additionalInformation) {
        this.session = session;
        this.em = em;
        this.additionalInformation = additionalInformation;
        this.invoice = invoice;
    }

    @Override
    public InvoiceAdditionalInformationEntity getEntity() {
        return additionalInformation;
    }

    @Override
    public String getId() {
        return additionalInformation.getId();
    }

    @Override
    public BigDecimal getAmmount() {
        return additionalInformation.getAmmount();
    }

    @Override
    public void setAmmount(BigDecimal ammount) {
        additionalInformation.setAmmount(ammount);
    }

    @Override
    public DocumentSavedModel getDocument() {
        return new DocumentSavedAdapter(session, em, additionalInformation.getDocument());
    }

    @Override
    public void setDocument(String documentName, String documentId) {
        DocumentSavedEntity document = new DocumentSavedEntity();
        document.setName(documentName);
        document.setDocumentId(documentId);
        additionalInformation.setDocument(document);
    }

    @Override
    public InvoiceModel getInvoice() {
        return invoice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
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
        InvoiceAdditionalInformationAdapter other = (InvoiceAdditionalInformationAdapter) obj;
        if (additionalInformation == null) {
            if (other.additionalInformation != null)
                return false;
        } else if (!additionalInformation.equals(other.additionalInformation))
            return false;
        return true;
    }

}
