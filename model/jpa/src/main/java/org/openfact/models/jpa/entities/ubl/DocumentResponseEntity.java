package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an application-level response to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponseEntity {

    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<LineResponseEntity> LineResponses = new ArrayList<>();
    private PartyEntity RecipientParty;
    private PartyEntity IssuerParty;
    private List<ResponseEntity> Responses = new ArrayList<>();

}
