package org.openfact.models.ubl.common;

public interface PersonModel {

    FirstNameModel getFirstName();

    void setFirstName(FirstNameModel value);

    FamilyNameModel getFamilyName();

    void setFamilyName(FamilyNameModel value);

    TitleModel getTitle();

    void setTitle(TitleModel value);

    MiddleNameModel getMiddleName();

    void setMiddleName(MiddleNameModel value);

    NameSuffixModel getNameSuffix();

    void setNameSuffix(NameSuffixModel value);

    JobTitleModel getJobTitle();

    void setJobTitle(JobTitleModel value);

    OrganizationDepartmentModel getOrganizationDepartment();

    void setOrganizationDepartment(OrganizationDepartmentModel value);

    String getId();

    void setId(String value);

}
