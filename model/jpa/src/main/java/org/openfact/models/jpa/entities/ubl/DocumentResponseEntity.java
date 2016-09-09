package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe an application-level response to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponseEntity {

	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
	private List<LineResponseEntity> lineresponses = new ArrayList<>();
	private PartyEntity recipientParty;
	private PartyEntity issuerParty;
	private List<ResponseEntity> responses = new ArrayList<>();

}
