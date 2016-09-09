package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe a period of time.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class PeriodEntity {

	/**
	 * A description of this period, expressed as text.
	 */
	private TextType description;
	/**
	 * A description of this period, expressed as a code.
	 */
	private CodeType descriptionCode;
	/**
	 * The duration of this period, expressed as an ISO 8601 code.
	 */
	private MeasureType durationMeasure;
	/**
	 * The date on which this period ends.
	 */
	private LocalDate endDate;
	/**
	 * The time at which this period ends.
	 */
	private LocalTime endTime;
	/**
	 * The date on which this period begins.
	 */
	private LocalDate startDate;
	/**
	 * The time at which this period begins.
	 */
	private LocalTime startTime;

}
