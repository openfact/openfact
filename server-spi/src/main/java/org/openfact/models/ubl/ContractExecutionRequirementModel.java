package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a requirement for execution of a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:01 a. m.
 */
public class ContractExecutionRequirementModel {

    /**
     * Text describing this requirement.
     */
    private TextModel description;
    /**
     * A code signifying the type of party independent of its role.
     */
    private CodeModel executionRequirementCode;
    /**
     * A name for this requirement.
     */
    private NameModel name;

}
