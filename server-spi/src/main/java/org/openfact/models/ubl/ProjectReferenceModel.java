package org.openfact.models.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a reference to a procurement project.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:07 a. m.
 */
public class ProjectReferenceModel {

    /**
     * An identifier for the referenced project.
     */
    private IdentifierType ID;
    /**
     * The date on which the referenced project was issued.
     */
    private LocalDate issueDate;
    /**
     * A universally unique identifier for the referenced project.
     */
    private IdentifierType UUID;
    private List<WorkPhaseReferenceModel> workPhaseReferences = new ArrayList<>();

}
