package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe a requirement for execution of a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:01 a. m.
 */
public class ContractExecutionRequirementRepresentation {

    /**
     * Text describing this requirement.
     */
    private TextType description;
    /**
     * A code signifying the type of party independent of its role.
     */
    private CodeType executionRequirementCode;
    /**
     * A name for this requirement.
     */
    private NameType name;

}