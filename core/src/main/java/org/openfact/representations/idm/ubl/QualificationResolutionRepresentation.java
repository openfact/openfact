package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the acceptance or rejection of an economic operator in a
 * tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:13 a. m.
 */
public class QualificationResolutionRepresentation {

    /**
     * An indicator that the economic operator has been accepted into the
     * tendering process (true) or rejected from the tendering process (false).
     */
    private CodeRepresentation admissionCode;
    /**
     * Text describing a reason for an exclusion from the tendering process.
     */
    private TextRepresentation exclusionReason;
    /**
     * Text describing this qualification resolution.
     */
    private TextRepresentation resolution;
    /**
     * The date on which this qualification resolution was formalized.
     */
    private LocalDate resolutionDate;
    /**
     * The time at which this qualification resolution was formalized.
     */
    private LocalTime resolutionTime;
    private List<ProcurementProjectLotRepresentation> procurementProjectLots = new ArrayList<>();

}
