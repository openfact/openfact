package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a person.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:46 a. m.
 */
public class PersonEntity {

    /**
     * This person's date of birth.
     */
    private DateType birthDate;
    /**
     * The name of the place where this person was born, expressed as text.
     */
    private TextType birthplaceName;
    /**
     * This person's family name.
     */
    private NameType familyName;
    /**
     * This person's given name.
     */
    private NameType firstName;
    /**
     * A code (e.g., ISO 5218) signifying the gender of this person.
     */
    private CodeType genderCode;
    /**
     * An identifier for this person.
     */
    private IdentifierType ID;
    /**
     * This person's job title (for a particular role) within an organization.
     */
    private TextType jobtitle;
    /**
     * This person's middle name(s) or initials.
     */
    private NameType middleName;
    /**
     * A suffix to this person's name (e.g., PhD, OBE, Jr).
     */
    private TextType nameSuffix;
    /**
     * An identifier for this person's nationality.
     */
    private IdentifierType nationalityID;
    /**
     * The department or subdivision of an organization that this person belongs
     * to (in a particular role).
     */
    private TextType organizationDepartment;
    /**
     * This person's second family name.
     */
    private NameType otherName;
    /**
     * This person's title of address (e.g., Mr, Ms, Dr, Sir).
     */
    private TextType title;
    private AddressEntity residenceAddress;
    private List<ContactEntity> contacts = new ArrayList<>();
    private DocumentReferenceEntity identityDocumentReference;
    private List<FinancialAccountEntity> financialAccounts = new ArrayList<>();

}
