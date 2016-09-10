package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;

/**
 * A class to describe one of the parts of a procurement project that is being
 * subdivided to allow the contracting party to award different lots to
 * different economic operators under different contracts.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:05 a. m.
 */
public class ProcurementProjectLotRepresentation {

    /**
     * An identifier for this procurement project lot.
     */
    private IdentifierType ID;
    private List<ProcurementProjectRepresentation> procurementProjects = new ArrayList<>();
    private List<TenderingTermsRepresentation> tenderingTermses = new ArrayList<>();

}
