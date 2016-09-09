package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe responses to a line in a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:58 a. m.
 */
public class LineResponseEntity {

    private List<LineReferenceEntity> lineReferences = new ArrayList<>();
    private List<ResponseEntity> responses = new ArrayList<>();

}
