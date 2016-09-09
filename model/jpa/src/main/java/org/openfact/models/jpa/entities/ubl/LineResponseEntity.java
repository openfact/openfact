package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe responses to a line in a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:58 a. m.
 */
public class LineResponseEntity {

	private List<LineReferenceEntity> lineReferences = new ArrayList<>();
	private List<ResponseEntity> responses = new ArrayList<>();

}
