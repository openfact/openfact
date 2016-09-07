package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class describing the supply of a telecommunication service, e.g., providing
 * telephone calls.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:10 a. m.
 */
public class TelecommunicationsSupply {

    /**
     * Text describing the telecommunications supply.
     */
    private String Description;
    /**
     * A code signifying the level of confidentiality of this information for
     * this telecommunication supply.
     */
    private String PrivacyCode;
    /**
     * The type of telecommunications supply, expressed as text.
     */
    private String TelecommunicationsSupplyType;
    /**
     * The type of telecommunications supply, expressed as a code.
     */
    private String TelecommunicationsSupplyTypeCode;
    /**
     * The total amount associated with this telecommunications supply.
     */
    private BigDecimal TotalAmount;
    private List<TelecommunicationsSupplyLine> telecommunicationsSupplyLines = new ArrayList<>();

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
     * @return the privacyCode
     */
    public String getPrivacyCode() {
        return PrivacyCode;
    }

    /**
     * @param privacyCode
     *            the privacyCode to set
     */
    public void setPrivacyCode(String privacyCode) {
        PrivacyCode = privacyCode;
    }

    /**
     * @return the telecommunicationsSupplyType
     */
    public String getTelecommunicationsSupplyType() {
        return TelecommunicationsSupplyType;
    }

    /**
     * @param telecommunicationsSupplyType
     *            the telecommunicationsSupplyType to set
     */
    public void setTelecommunicationsSupplyType(String telecommunicationsSupplyType) {
        TelecommunicationsSupplyType = telecommunicationsSupplyType;
    }

    /**
     * @return the telecommunicationsSupplyTypeCode
     */
    public String getTelecommunicationsSupplyTypeCode() {
        return TelecommunicationsSupplyTypeCode;
    }

    /**
     * @param telecommunicationsSupplyTypeCode
     *            the telecommunicationsSupplyTypeCode to set
     */
    public void setTelecommunicationsSupplyTypeCode(String telecommunicationsSupplyTypeCode) {
        TelecommunicationsSupplyTypeCode = telecommunicationsSupplyTypeCode;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    /**
     * @param totalAmount
     *            the totalAmount to set
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        TotalAmount = totalAmount;
    }

    /**
     * @return the telecommunicationsSupplyLines
     */
    public List<TelecommunicationsSupplyLine> getTelecommunicationsSupplyLines() {
        return telecommunicationsSupplyLines;
    }

    /**
     * @param telecommunicationsSupplyLines
     *            the telecommunicationsSupplyLines to set
     */
    public void setTelecommunicationsSupplyLines(
            List<TelecommunicationsSupplyLine> telecommunicationsSupplyLines) {
        this.telecommunicationsSupplyLines = telecommunicationsSupplyLines;
    }

}