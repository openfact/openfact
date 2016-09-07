package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a line describing a request for a catalogue line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:25 a. m.
 */
public class CatalogueRequestLine {

    /**
     * A subdivision of a contract or tender covering the line being requested.
     */
    private String ContractSubdivision;
    /**
     * An identifier for the requested catalogue line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    private Item m_Item;
    private ItemLocationQuantity RequiredItemLocationQuantity;
    private Period LineValidityPeriod;

    public CatalogueRequestLine() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the contractSubdivision
     */
    public String getContractSubdivision() {
        return ContractSubdivision;
    }

    /**
     * @param contractSubdivision
     *            the contractSubdivision to set
     */
    public void setContractSubdivision(String contractSubdivision) {
        ContractSubdivision = contractSubdivision;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the m_Item
     */
    public Item getM_Item() {
        return m_Item;
    }

    /**
     * @param m_Item
     *            the m_Item to set
     */
    public void setM_Item(Item m_Item) {
        this.m_Item = m_Item;
    }

    /**
     * @return the requiredItemLocationQuantity
     */
    public ItemLocationQuantity getRequiredItemLocationQuantity() {
        return RequiredItemLocationQuantity;
    }

    /**
     * @param requiredItemLocationQuantity
     *            the requiredItemLocationQuantity to set
     */
    public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
        RequiredItemLocationQuantity = requiredItemLocationQuantity;
    }

    /**
     * @return the lineValidityPeriod
     */
    public Period getLineValidityPeriod() {
        return LineValidityPeriod;
    }

    /**
     * @param lineValidityPeriod
     *            the lineValidityPeriod to set
     */
    public void setLineValidityPeriod(Period lineValidityPeriod) {
        LineValidityPeriod = lineValidityPeriod;
    }

}// end Catalogue Request Line