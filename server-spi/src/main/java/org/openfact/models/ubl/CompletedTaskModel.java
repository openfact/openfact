package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the completion of a specific task in the tendering
 * process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:40 a. m.
 */
public class CompletedTaskModel {

    /**
     * The average monetary amount of a task such as this completed task.
     */
    private BigDecimal annualAverageAmount;
    /**
     * Text describing this completed task.
     */
    private TextType description;
    /**
     * A monetary amount corresponding to the financial capacity of the party
     * that carried out this completed task.
     */
    private BigDecimal partyCapacityAmount;
    /**
     * The actual total monetary amount of this completed task.
     */
    private BigDecimal totalTaskAmount;
    private CustomerPartyModel recipientCustomerParty;
    private List<EvidenceSuppliedModel> evidenceSupplieds = new ArrayList<>();
    private List<PeriodModel> periods = new ArrayList<>();

}
