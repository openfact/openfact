package org.openfact.models.ubl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a person.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:46 a. m.
 */
public class PersonModel {

    /**
     * This person's date of birth.
     */
    private LocalDate birthDate;
    /**
     * The name of the place where this person was born, expressed as text.
     */
    private TextModel birthplaceName;
    /**
     * This person's family name.
     */
    private NameModel familyName;
    /**
     * This person's given name.
     */
    private NameModel firstName;
    /**
     * A code (e.g., ISO 5218) signifying the gender of this person.
     */
    private CodeModel genderCode;
    /**
     * An identifier for this person.
     */
    private IdentifierModel ID;
    /**
     * This person's job title (for a particular role) within an organization.
     */
    private TextModel jobTitle;
    /**
     * This person's middle name(s) or initials.
     */
    private NameModel middleName;
    /**
     * A suffix to this person's name (e.g., PhD, OBE, Jr).
     */
    private TextModel nameSuffix;
    /**
     * An identifier for this person's nationality.
     */
    private IdentifierModel nationalityID;
    /**
     * The department or subdivision of an organization that this person belongs
     * to (in a particular role).
     */
    private TextModel organizationDepartment;
    /**
     * This person's second family name.
     */
    private NameModel otherName;
    /**
     * This person's title of address (e.g., Mr, Ms, Dr, Sir).
     */
    private TextModel title;
    private AddressModel residenceAddress;
    private List<ContactModel> contacts = new ArrayList<>();
    private DocumentReferenceModel identityDocumentReference;
    private List<FinancialAccountModel> financialAccounts = new ArrayList<>();

}
