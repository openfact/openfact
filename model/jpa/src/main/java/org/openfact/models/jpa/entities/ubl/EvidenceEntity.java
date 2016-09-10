package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe an item of evidentiary support for representations of
 * capabilities or the ability to meet tendering requirements, which an economic
 * operator must provide for acceptance into a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:01 a. m.
 */
public class EvidenceEntity {

    /**
     * Information about a candidate statement that the contracting authority
     * accepts as a sufficient response.
     */
    private TextType candidateStatement;
    /**
     * The textual description for this Evidence.
     */
    private TextType description;
    /**
     * A code signifying the type of evidence.
     */
    private CodeType evidenceTypeCode;
    /**
     * An identifier for this item of evidentiary support.
     */
    private IdentifierType ID;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<LanguageEntity> languages = new ArrayList<>();
    private PartyEntity evidenceIssuingParty;

}
