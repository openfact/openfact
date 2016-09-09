package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.TextType;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.SubstitutionStatusCodeType;

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
    private TextType Note;
    /**
     * A code signifying the substitution status of the item on this order line.
     * The order line may indicate that the substitute is proposed by the buyer
     * (in Order) or by the seller (in OrderResponse) or that a substitution has
     * been made by the seller (in Order
     */
    private SubstitutionStatusCodeType SubstitutionStatusCode;
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<LineItemEntity> SellerProposedSubstituteLineItem = new ArrayList<>();
    private List<LineItemEntity> SellerSubstitutedLineItem = new ArrayList<>();
    private List<LineItemEntity> LineItems = new ArrayList<>();
    private List<LineItemEntity> BuyerProposedSubstituteLineItem = new ArrayList<>();
    private LineReferenceEntity CatalogueLineReference;
    private LineReferenceEntity QuotationLineReference;
    private List<OrderLineReferenceEntity> OrderLineReferences = new ArrayList<>();

}
