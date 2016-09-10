package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private CodeType declarationTypeCode;
    /**
     * Text describing this declaration.
     */
    private TextType description;
    /**
     * The name of this declaration.
     */
    private NameType name;
    private List<EvidenceSuppliedRepresentation> evidenceSupplieds = new ArrayList<>();

}
