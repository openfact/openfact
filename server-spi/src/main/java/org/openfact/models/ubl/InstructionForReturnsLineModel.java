package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in an Instruction for Returns.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:33 a. m.
 */
public class InstructionForReturnsLineModel {

    /**
     * An identifier for this instruction for returns line.
     */
    private IdentifierType ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The quantity of goods being returned.
     */
    private QuantityType quantity;
    private List<ItemModel> items = new ArrayList<>();
    private PartyModel manufacturerParty;

}
