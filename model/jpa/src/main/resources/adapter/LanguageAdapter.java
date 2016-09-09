package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a language.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:54 a. m.
 */
public class LanguageAdapter{

	/**
	 * An identifier for this language.
	 */
	private IdentifierType ID; 
	/**
	 * A code signifying the locale in which this language is used.
	 */
	private CodeType localeCode; 
	/**
	 * The name of this language.
	 */
	private NameType name; 

}
