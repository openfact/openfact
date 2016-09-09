package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe the acceptance or rejection of an economic operator in a
 * tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:13 a. m.
 */
public class QualificationresolutionEntity {

    /**
     * An indicator that the economic operator has been accepted into the
     * tendering process (true) or rejected from the tendering process (false).
     */
    private CodeType admissionCode;
    /**
     * Text describing a reason for an exclusion from the tendering process.
     */
    private TextType exclusionReason;
    /**
     * Text describing this qualification resolution.
     */
    private TextType resolution;
    /**
     * The date on which this qualification resolution was formalized.
     */
    private DateType resolutionDate;
    /**
     * The time at which this qualification resolution was formalized.
     */
    private TimeType resolutionTime;
    private List<ProcurementProjectLotEntity> procurementProjectLots = new ArrayList<>();

}
