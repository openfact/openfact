package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a declaration by an economic operator of certain
 * characteristics or capabilities in fulfilment of requirements specified in a
 * call for tenders.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:20 a. m.
 */
public class DeclarationEntity {

    /**
     * A code signifying the type of this declaration.
     */
    private CodeType DeclarationTypeCode;
    /**
     * Text describing this declaration.
     */
    private TextType Description;
    /**
     * The name of this declaration.
     */
    private NameType Name;
    private List<EvidenceSuppliedEntity> EvidenceSupplieds = new ArrayList<>();

}
