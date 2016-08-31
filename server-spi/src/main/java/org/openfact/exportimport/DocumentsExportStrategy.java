package org.openfact.exportimport;

public enum DocumentsExportStrategy {

	/**
	 * Exporting of document will be skipped completely
	 */
	SKIP,

	/**
	 * All documents will be exported to same file with organization (So file
	 * like "foo-organization.json" with both organization data and documents)
	 */
	ORGANIZATION_FILE,

	/**
	 * All documents will be exported to same file but different than
	 * organization (So file like "foo-organization.json" with organization data
	 * and "foo-documents.json" with users)
	 */
	SAME_FILE,

	/**
	 * Documents will be exported into more different files according to maximum
	 * number of documents per file
	 */
	DIFFERENT_FILES
}
