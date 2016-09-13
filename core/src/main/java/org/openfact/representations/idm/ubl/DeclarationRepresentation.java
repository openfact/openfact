package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a declaration by an economic operator of certain
 * characteristics or capabilities in fulfilment of requirements specified in a
 * call for tenders.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:20 a. m.
 */
public class DeclarationRepresentation {

    /**
     * A code signifying the type of this declaration.
     */
    private CodeRepresentation declarationTypeCode;
    /**
     * Text describing this declaration.
     */
    private TextRepresentation description;
    /**
     * The name of this declaration.
     */
    private NameRepresentation name;
    private List<EvidenceSuppliedRepresentation> evidenceSupplieds = new ArrayList<>();

}
