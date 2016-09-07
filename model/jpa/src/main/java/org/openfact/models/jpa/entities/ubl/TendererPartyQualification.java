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

	private ProcurementProjectLot InterestedProcurementProjectLot;
	private QualifyingParty MainQualifyingParty;
	private QualifyingParty AdditionalQualifyingParty;

	/**
	 * @return the interestedProcurementProjectLot
	 */
	public ProcurementProjectLot getInterestedProcurementProjectLot() {
		return InterestedProcurementProjectLot;
	}

	/**
	 * @param interestedProcurementProjectLot
	 *            the interestedProcurementProjectLot to set
	 */
	public void setInterestedProcurementProjectLot(ProcurementProjectLot interestedProcurementProjectLot) {
		InterestedProcurementProjectLot = interestedProcurementProjectLot;
	}

	/**
	 * @return the mainQualifyingParty
	 */
	public QualifyingParty getMainQualifyingParty() {
		return MainQualifyingParty;
	}

	/**
	 * @param mainQualifyingParty
	 *            the mainQualifyingParty to set
	 */
	public void setMainQualifyingParty(QualifyingParty mainQualifyingParty) {
		MainQualifyingParty = mainQualifyingParty;
	}

	/**
	 * @return the additionalQualifyingParty
	 */
	public QualifyingParty getAdditionalQualifyingParty() {
		return AdditionalQualifyingParty;
	}

	/**
	 * @param additionalQualifyingParty
	 *            the additionalQualifyingParty to set
	 */
	public void setAdditionalQualifyingParty(QualifyingParty additionalQualifyingParty) {
		AdditionalQualifyingParty = additionalQualifyingParty;
	}

}// end TendererPartyQualification