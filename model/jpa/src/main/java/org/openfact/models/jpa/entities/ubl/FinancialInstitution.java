package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a financial institution.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:14 a. m.
 */
public class FinancialInstitution {

    /**
     * An identifier for this financial institution. It is recommended that the
     * ISO 9362 Bank Identification Code (BIC) be used as the ID.
     */
    private String ID;
    /**
     * The name of this financial institution.
     */
    private String name;
    private Address m_Address;

    public FinancialInstitution() {

    }

    public void finalize() throws Throwable {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getM_Address() {
        return m_Address;
    }

    public void setM_Address(Address m_Address) {
        this.m_Address = m_Address;
    }
}// end Financial Institution