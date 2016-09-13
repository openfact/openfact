package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a person.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:46 a. m.
 */
public class PersonRepresentation {

    /**
     * This person's date of birth.
     */
    private LocalDate birthDate;
    /**
     * The name of the place where this person was born, expressed as text.
     */
    private TextRepresentation birthplaceName;
    /**
     * This person's family name.
     */
    private NameRepresentation familyName;
    /**
     * This person's given name.
     */
    private NameRepresentation firstName;
    /**
     * A code (e.g., ISO 5218) signifying the gender of this person.
     */
    private CodeRepresentation genderCode;
    /**
     * An identifier for this person.
     */
    private IdentifierRepresentation ID;
    /**
     * This person's job title (for a particular role) within an organization.
     */
    private TextRepresentation jobTitle;
    /**
     * This person's middle name(s) or initials.
     */
    private NameRepresentation middleName;
    /**
     * A suffix to this person's name (e.g., PhD, OBE, Jr).
     */
    private TextRepresentation nameSuffix;
    /**
     * An identifier for this person's nationality.
     */
    private IdentifierRepresentation nationalityID;
    /**
     * The department or subdivision of an organization that this person belongs
     * to (in a particular role).
     */
    private TextRepresentation organizationDepartment;
    /**
     * This person's second family name.
     */
    private NameRepresentation otherName;
    /**
     * This person's title of address (e.g., Mr, Ms, Dr, Sir).
     */
    private TextRepresentation title;
    private AddressRepresentation residenceAddress;
    private List<ContactRepresentation> contacts = new ArrayList<>();
    private DocumentReferenceRepresentation identityDocumentReference;
    private List<FinancialAccountRepresentation> financialAccounts = new ArrayList<>();

}
