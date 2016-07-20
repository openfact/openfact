package org.openfact.representations.idm;

public class AdminEventRepresentation {

	private long time;
	private String organizationId;
	private AuthDetailsRepresentation authDetails;
	private String operationType;
	private String resourcePath;
	private String representation;
	private String error;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public AuthDetailsRepresentation getAuthDetails() {
		return authDetails;
	}

	public void setAuthDetails(AuthDetailsRepresentation authDetails) {
		this.authDetails = authDetails;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
