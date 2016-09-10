package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe responses to a line in a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:58 a. m.
 */
public class LineResponseModel {

    private List<LineReferenceModel> lineReferences = new ArrayList<>();
    private List<ResponseModel> responses = new ArrayList<>();

}
