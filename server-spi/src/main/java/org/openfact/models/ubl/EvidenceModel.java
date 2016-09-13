package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe an item of evidentiary support for representations of
 * capabilities or the ability to meet tendering requirements, which an economic
 * operator must provide for acceptance into a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:01 a. m.
 */
public class EvidenceModel {

    /**
     * Information about a candidate statement that the contracting authority
     * accepts as a sufficient response.
     */
    private TextModel candidateStatement;
    /**
     * The textual description for this Evidence.
     */
    private TextModel description;
    /**
     * A code signifying the type of evidence.
     */
    private CodeModel evidenceTypeCode;
    /**
     * An identifier for this item of evidentiary support.
     */
    private IdentifierModel ID;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<LanguageModel> languages = new ArrayList<>();
    private PartyModel evidenceIssuingParty;

}
