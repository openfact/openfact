package org.openfact.models.jpa.entities.ublType;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by lxpary on 08/09/16.
 */
@Embeddable
@Access(AccessType.FIELD)
public class BinaryObjectType {
	@Column(name = "VALUE")
	protected byte[] value;
	@Column(name = "FORMAT")
	protected String format;

	// protected BinaryObjectMimeCodeContentType mimeCode;

	@Column(name = "ENCODING_CODE")
	protected String encodingCode;
	@Column(name = "CHARACTER_SET_CODE")
	protected String characterSetCode;
	@Column(name = "URI")
	protected String uri;
	@Column(name = "FILE_NAME")
	protected String filename;

	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getEncodingCode() {
		return encodingCode;
	}

	public void setEncodingCode(String encodingCode) {
		this.encodingCode = encodingCode;
	}

	public String getCharacterSetCode() {
		return characterSetCode;
	}

	public void setCharacterSetCode(String characterSetCode) {
		this.characterSetCode = characterSetCode;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
