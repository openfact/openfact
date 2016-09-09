package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an order document (e.g., Order, OrderChange, or
 * OrderResponse) describing an item being ordered.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:15 a. m.
 */
public class OrderLineModel{

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the substitution status of the item on this order line. The
	 * order line may indicate that the substitute is proposed by the buyer (in Order)
	 * or by the seller (in OrderResponse) or that a substitution has been made by
	 * the seller (in Order
	 */
	private SubstitutionStatusCodeType substitutionStatusCode; 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<LineItemModel> sellerProposedSubstituteLineItem = new ArrayList<>(); 
	private List<LineItemModel> sellerSubstitutedLineItem = new ArrayList<>(); 
	private List<LineItemModel> lineItems = new ArrayList<>(); 
	private List<LineItemModel> buyerProposedSubstituteLineItem = new ArrayList<>(); 
	private LineReferenceModel catalogueLineReference; 
	private LineReferenceModel quotationLineReference; 
	private List<OrderLineReferenceModel> orderLineReferences = new ArrayList<>(); 

}
