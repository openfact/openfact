package org.openfact.representations;

public class KeyStoreConfig {

	protected Boolean organizationCertificate;
	protected String storePassword;
	protected String keyPassword;
	protected String keyAlias;
	protected String realmAlias;
	protected String format;

	/**
	 * @return the organizationCertificate
	 */
	public Boolean isOrganizationCertificate() {
		return organizationCertificate;
	}

	/**
	 * @param organizationCertificate
	 *            the organizationCertificate to set
	 */
	public void setOrganizationCertificate(Boolean organizationCertificate) {
		this.organizationCertificate = organizationCertificate;
	}

	/**
	 * @return the storePassword
	 */
	public String getStorePassword() {
		return storePassword;
	}

	/**
	 * @param storePassword
	 *            the storePassword to set
	 */
	public void setStorePassword(String storePassword) {
		this.storePassword = storePassword;
	}

	/**
	 * @return the keyPassword
	 */
	public String getKeyPassword() {
		return keyPassword;
	}

	/**
	 * @param keyPassword
	 *            the keyPassword to set
	 */
	public void setKeyPassword(String keyPassword) {
		this.keyPassword = keyPassword;
	}

	/**
	 * @return the keyAlias
	 */
	public String getKeyAlias() {
		return keyAlias;
	}

	/**
	 * @param keyAlias
	 *            the keyAlias to set
	 */
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}

	/**
	 * @return the realmAlias
	 */
	public String getRealmAlias() {
		return realmAlias;
	}

	/**
	 * @param realmAlias
	 *            the realmAlias to set
	 */
	public void setRealmAlias(String realmAlias) {
		this.realmAlias = realmAlias;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

}
