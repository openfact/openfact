package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe the completion of a specific task in the tendering
 * process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:40 a. m.
 */
public class CompletedTaskEntity {

    /**
     * The average monetary amount of a task such as this completed task.
     */
    private AmountType AnnualAverageAmount;
    /**
     * Text describing this completed task.
     */
    private TextType Description;
    /**
     * A monetary amount corresponding to the financial capacity of the party
     * that carried out this completed task.
     */
    private AmountType PartyCapacityAmount;
    /**
     * The actual total monetary amount of this completed task.
     */
    private AmountType TotalTaskAmount;
    private CustomerPartyEntity RecipientCustomerParty;
    private List<EvidenceSuppliedEntity> EvidenceSupplieds = new ArrayList<>();
    private List<PeriodEntity> Periods = new ArrayList<>();

}
