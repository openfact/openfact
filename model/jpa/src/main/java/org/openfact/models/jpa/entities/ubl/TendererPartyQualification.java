package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the qualifications of a tenderer party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:22 a. m.
 */
public class TendererPartyQualification {

	private ProcurementProjectLot interestedProcurementProjectLot;
	private QualifyingParty mainQualifyingParty;
	private QualifyingParty additionalQualifyingParty;

	public ProcurementProjectLot getInterestedProcurementProjectLot() {
		return interestedProcurementProjectLot;
	}

	public void setInterestedProcurementProjectLot(ProcurementProjectLot interestedProcurementProjectLot) {
		this.interestedProcurementProjectLot = interestedProcurementProjectLot;
	}

	public QualifyingParty getMainQualifyingParty() {
		return mainQualifyingParty;
	}

	public void setMainQualifyingParty(QualifyingParty mainQualifyingParty) {
		this.mainQualifyingParty = mainQualifyingParty;
	}

	public QualifyingParty getAdditionalQualifyingParty() {
		return additionalQualifyingParty;
	}

	public void setAdditionalQualifyingParty(QualifyingParty additionalQualifyingParty) {
		this.additionalQualifyingParty = additionalQualifyingParty;
	}
}// end TendererPartyQualification