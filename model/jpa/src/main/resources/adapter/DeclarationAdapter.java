package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a declaration by an economic operator of certain
 * characteristics or capabilities in fulfilment of requirements specified in a
 * call for tenders.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:20 a. m.
 */
public class DeclarationAdapter{

	/**
	 * A code signifying the type of this declaration.
	 */
	private CodeType declarationTypeCode; 
	/**
	 * Text describing this declaration.
	 */
	private TextType description; 
	/**
	 * The name of this declaration.
	 */
	private NameType name; 
	private List<EvidenceSuppliedAdapter> evidenceSupplieds = new ArrayList<>(); 

}
