package org.openfact.models.catalog;

import java.math.BigDecimal;

public interface ConditionCatalogModel {
	String getId();

	String getID();

	String getCode();

	void setCode(String code);

	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	BigDecimal getValue();

	void setValue(BigDecimal value);

	String getLocale();

	void setLocale(String locale);
}
