package org.openfact.representations.idm;

import java.util.Map;

public class EventRepresentation {

	private long time;
	private String type;
	private String organizationId;
	// private String clientId;
	private String userId;
	private String sessionId;
	private String ipAddress;
	private String error;
	private Map<String, String> details;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	/*
	 * public String getClientId() { return clientId; }
	 * 
	 * public void setClientId(String clientId) { this.clientId = clientId; }
	 */

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Map<String, String> getDetails() {
		return details;
	}

	public void setDetails(Map<String, String> details) {
		this.details = details;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EventRepresentation that = (EventRepresentation) o;

		if (time != that.time)
			return false;
		if (type != null ? !type.equals(that.type) : that.type != null)
			return false;
		if (organizationId != null ? !organizationId.equals(that.organizationId) : that.organizationId != null)
			return false;
		/*
		 * if (clientId != null ? !clientId.equals(that.clientId) :
		 * that.clientId != null) return false;
		 */
		if (userId != null ? !userId.equals(that.userId) : that.userId != null)
			return false;
		if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null)
			return false;
		if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null)
			return false;
		if (error != null ? !error.equals(that.error) : that.error != null)
			return false;
		return !(details != null ? !details.equals(that.details) : that.details != null);

	}

	@Override
	public int hashCode() {
		int result = (int) (time ^ (time >>> 32));
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
		// result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
		result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
		result = 31 * result + (error != null ? error.hashCode() : 0);
		result = 31 * result + (details != null ? details.hashCode() : 0);
		return result;
	}
}
