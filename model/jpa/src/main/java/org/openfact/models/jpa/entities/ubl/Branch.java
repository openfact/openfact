package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a branch or a division of an organization.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class Branch {

    private String ID;
    private String Name;
    private Address m_Address;
    private FinancialInstitution m_FinancialInstitution;

    /**
     * An identifier for this branch or division of an organization.
     */
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * The name of this branch or division of an organization.
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Address getM_Address() {
        return m_Address;
    }

    public void setM_Address(Address m_Address) {
        this.m_Address = m_Address;
    }

    public FinancialInstitution getM_FinancialInstitution() {
        return m_FinancialInstitution;
    }

    public void setM_FinancialInstitution(FinancialInstitution m_FinancialInstitution) {
        this.m_FinancialInstitution = m_FinancialInstitution;
    }
}// end Branch