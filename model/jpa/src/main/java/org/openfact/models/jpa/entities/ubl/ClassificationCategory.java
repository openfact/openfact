package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a category within a classification scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:31 a. m.
 */
public class ClassificationCategory {

	/**
	 * The value of a code used to identify this category within the
	 * classification scheme.
	 */
	private String codeValue;
	/**
	 * Text describing this category.
	 */
	private String description;
	/**
	 * The name of this category within the classification scheme.
	 */
	private String name;
	private ClassificationCategory categorizesClassificationCategory;

	public ClassificationCategory() {

	}

	public void finalize() throws Throwable {

	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassificationCategory getCategorizesClassificationCategory() {
		return categorizesClassificationCategory;
	}

	public void setCategorizesClassificationCategory(ClassificationCategory categorizesClassificationCategory) {
		this.categorizesClassificationCategory = categorizesClassificationCategory;
	}
}// end Classification Category