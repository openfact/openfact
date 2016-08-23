package org.openfact.representations.idm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedRepresentation {
	/**
	 * The unique id.
	 */
	private String id;

	/**
	 * The alias of the certified
	 */
	@NotNull
	@Size(min = 5, max = 100)
	private String alias;

	/**
	 * The certificate of the certified
	 */

	private File certificate;

	/**
	 * The certificate of the certified
	 */

	private String urlcertificate;
	/**
	 * The password of the certified
	 */
	@NotNull
	@Size(min = 6, max = 100)
	private String password;

	/**
	 * The password of the certified
	 */
	@NotNull
	@Size(min = 6, max = 100)
	private String passwordConfirmation;

	/**
	 * The validity of the certified(fecha vigencia)
	 */
	@NotNull
	private LocalDate validity;

	/**
	 * The hasCertificate of the certified(Estado Tiene Certificado)
	 */
	@NotNull
	private boolean hasCertificate;
	/**
	 * The status of the certified(Estado Certificado)
	 */

	private boolean status;

	private String fileType;

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isHasCertificate() {
		return hasCertificate;
	}

	public void setHasCertificate(boolean hasCertificate) {
		this.hasCertificate = hasCertificate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public File getCertificate() {
		return certificate;
	}

	public void setCertificate(File certificate) {
		this.certificate = certificate;
	}

	public String getUrlcertificate() {
		return urlcertificate;
	}

	public void setUrlcertificate(String urlcertificate) {
		this.urlcertificate = urlcertificate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}
}
