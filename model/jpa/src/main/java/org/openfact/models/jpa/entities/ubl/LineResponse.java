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

	private LineReference m_LineReference;
	private Response m_Response;

	public LineResponse() {

	}

	public void finalize() throws Throwable {

	}

	public LineReference getM_LineReference() {
		return m_LineReference;
	}

	public void setM_LineReference(LineReference m_LineReference) {
		this.m_LineReference = m_LineReference;
	}

	public Response getM_Response() {
		return m_Response;
	}

	public void setM_Response(Response m_Response) {
		this.m_Response = m_Response;
	}
}// end LineResponse