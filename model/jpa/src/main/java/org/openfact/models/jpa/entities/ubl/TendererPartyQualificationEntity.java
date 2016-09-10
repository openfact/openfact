package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the qualifications of a tenderer party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:22 a. m.
 */
public class TendererPartyQualificationEntity {

    private ProcurementProjectLotEntity interestedProcurementProjectLot;
    private QualifyingPartyEntity mainQualifyingParty;
    private QualifyingPartyEntity additionalQualifyingParty;

}
