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
    private String description;
    /**
     * A code signifying the level of confidentiality of this information for
     * this telecommunication supply.
     */
    private String privacyCode;
    /**
     * The type of telecommunications supply, expressed as text.
     */
    private String telecommunicationsSupplyType;
    /**
     * The type of telecommunications supply, expressed as a code.
     */
    private String telecommunicationsSupplyTypeCode;
    /**
     * The total amount associated with this telecommunications supply.
     */
    private BigDecimal totalAmount;
    private List<TelecommunicationsSupplyLine> telecommunicationsSupplyLines = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivacyCode() {
        return privacyCode;
    }

    public void setPrivacyCode(String privacyCode) {
        this.privacyCode = privacyCode;
    }

    public String getTelecommunicationsSupplyType() {
        return telecommunicationsSupplyType;
    }

    public void setTelecommunicationsSupplyType(String telecommunicationsSupplyType) {
        this.telecommunicationsSupplyType = telecommunicationsSupplyType;
    }

    public String getTelecommunicationsSupplyTypeCode() {
        return telecommunicationsSupplyTypeCode;
    }

    public void setTelecommunicationsSupplyTypeCode(String telecommunicationsSupplyTypeCode) {
        this.telecommunicationsSupplyTypeCode = telecommunicationsSupplyTypeCode;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TelecommunicationsSupplyLine> getTelecommunicationsSupplyLines() {
        return telecommunicationsSupplyLines;
    }

    public void setTelecommunicationsSupplyLines(List<TelecommunicationsSupplyLine> telecommunicationsSupplyLines) {
        this.telecommunicationsSupplyLines = telecommunicationsSupplyLines;
    }
}