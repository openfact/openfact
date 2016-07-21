package org.openfact.exportimport;

public enum DocumentsExportStrategy {
    SKIP,               // Exporting of document will be skipped completely
    ORGANIZATION_FILE,  // All documents will be exported to same file with realm (So file like "foo-organization.json" with both organization data and documents)
    SAME_FILE,          // All documents will be exported to same file but different than organization (So file like "foo-organization.json" with organization data and "foo-documents.json" with users)
    DIFFERENT_FILES     // Documents will be exported into more different files according to maximum number of documents per file
}
