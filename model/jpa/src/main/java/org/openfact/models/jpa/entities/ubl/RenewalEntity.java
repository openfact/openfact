package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe the renewal of a commercial arrangement, such as a
 * contract or licence fee.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:26 a. m.
 */
public class RenewalEntity {

	/**
	 * The monetary amount of this renewal.
	 */
	private BigDecimal amount;
	private List<PeriodEntity> periods = new ArrayList<>();

}
