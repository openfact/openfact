package org.openfact.models.jpa.entities.ubl;

/**
 * A template for a required document in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:17 a. m.
 */
public class TenderRequirement {

    /**
     * Text describing this tender requirement.
     */
    private String Description;
    /**
     * A name of this tender requirement.
     */
    private String Name;
    private DocumentReference TemplateDocumentReference;

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the templateDocumentReference
     */
    public DocumentReference getTemplateDocumentReference() {
        return TemplateDocumentReference;
    }

    /**
     * @param templateDocumentReference
     *            the templateDocumentReference to set
     */
    public void setTemplateDocumentReference(DocumentReference templateDocumentReference) {
        TemplateDocumentReference = templateDocumentReference;
    }

}// end Tender Requirement