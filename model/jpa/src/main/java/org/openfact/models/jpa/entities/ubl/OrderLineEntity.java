package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.TextType;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.substitutionStatusCodeType;

/**
 * A class to define a line in an order document (e.g., Order, OrderChange, or
 * OrderResponse) describing an item being ordered.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:15 a. m.
 */
public class OrderLineEntity {

    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * A code signifying the substitution status of the item on this order line.
     * The order line may indicate that the substitute is proposed by the buyer
     * (in Order) or by the seller (in OrderResponse) or that a substitution has
     * been made by the seller (in Order
     */
    private substitutionStatusCodeType substitutionStatusCode;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<LineItemEntity> sellerProposedSubstituteLineItem = new ArrayList<>();
    private List<LineItemEntity> sellerSubstitutedLineItem = new ArrayList<>();
    private List<LineItemEntity> lineItems = new ArrayList<>();
    private List<LineItemEntity> buyerProposedSubstituteLineItem = new ArrayList<>();
    private LineReferenceEntity catalogueLineReference;
    private LineReferenceEntity quotationLineReference;
    private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();

}
