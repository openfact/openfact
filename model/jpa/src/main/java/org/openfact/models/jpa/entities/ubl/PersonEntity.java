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
    private DateType BirthDate;
    /**
     * The name of the place where this person was born, expressed as text.
     */
    private TextType BirthplaceName;
    /**
     * This person's family name.
     */
    private NameType FamilyName;
    /**
     * This person's given name.
     */
    private NameType FirstName;
    /**
     * A code (e.g., ISO 5218) signifying the gender of this person.
     */
    private CodeType GenderCode;
    /**
     * An identifier for this person.
     */
    private IdentifierType ID;
    /**
     * This person's job title (for a particular role) within an organization.
     */
    private TextType JobTitle;
    /**
     * This person's middle name(s) or initials.
     */
    private NameType MiddleName;
    /**
     * A suffix to this person's name (e.g., PhD, OBE, Jr).
     */
    private TextType NameSuffix;
    /**
     * An identifier for this person's nationality.
     */
    private IdentifierType NationalityID;
    /**
     * The department or subdivision of an organization that this person belongs
     * to (in a particular role).
     */
    private TextType OrganizationDepartment;
    /**
     * This person's second family name.
     */
    private NameType OtherName;
    /**
     * This person's title of address (e.g., Mr, Ms, Dr, Sir).
     */
    private TextType Title;
    private AddressEntity ResidenceAddress;
    private List<ContactEntity> Contacts = new ArrayList<>();
    private DocumentReferenceEntity IdentityDocumentReference;
    private List<FinancialAccountEntity> FinancialAccounts = new ArrayList<>();

}
