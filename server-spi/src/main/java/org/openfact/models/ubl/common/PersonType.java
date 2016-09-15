package org.openfact.models.ubl.common;

public interface PersonType {

    FirstNameType getFirstName();

    void setFirstName(FirstNameType value);

    FamilyNameType getFamilyName();

    void setFamilyName(FamilyNameType value);

    TitleType getTitle();

    void setTitle(TitleType value);

    MiddleNameType getMiddleName();

    void setMiddleName(MiddleNameType value);

    NameSuffixType getNameSuffix();

    void setNameSuffix(NameSuffixType value);

    JobTitleType getJobTitle();

    void setJobTitle(JobTitleType value);

    OrganizationDepartmentType getOrganizationDepartment();

    void setOrganizationDepartment(OrganizationDepartmentType value);

    String getId();

    void setId(String value);

}
