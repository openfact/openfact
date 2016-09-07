package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the tenderer contracting role.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:40 a. m.
 */
public class EconomicOperatorRole {

    /**
     * A code specifying the role of the party.
     */
    private String roleCode;
    /**
     * A textual description of the party role.
     */
    private String roleDescription;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}// end EconomicOperatorRole