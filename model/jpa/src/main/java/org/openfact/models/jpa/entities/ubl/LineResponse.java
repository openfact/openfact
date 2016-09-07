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
public class LineResponse {

	private List<LineReference> lineReferences=new ArrayList<>();
	private List<Response> responses=new ArrayList<>();

	public LineResponse() {

	}

	public void finalize() throws Throwable {

	}

	public List<LineReference> getLineReferences() {
		return lineReferences;
	}

	public void setLineReferences(List<LineReference> lineReferences) {
		this.lineReferences = lineReferences;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
}// end LineResponse