package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe access to a web site.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:57 a. m.
 */
public class WebSiteAccessModel{

	/**
	 * Text describing login details.
	 */
	private TextType login;
	/**
	 * A password to the web site.
	 */
	private TextType password;
	/**
	 * The Uniform Resource Identifier (URI) for this web site; i.e., its Uniform
	 * Resource Locator (URL).
	 */
	private IdentifierType URIID;

}
