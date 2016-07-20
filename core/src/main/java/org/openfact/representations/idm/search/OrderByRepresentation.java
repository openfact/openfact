package org.openfact.representations.idm.search;

public class OrderByRepresentation {

	private boolean ascending;

	private String name;

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
