package org.openfact.soa.legacy;

public interface DefinitionLoader extends SchemaLoader {

	void setProgressInfo(String info);

	boolean isAborted();

	boolean abort();

	void setNewBaseURI(String uri);

	String getFirstNewURI();
}
