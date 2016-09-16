package org.openfact.representations.idm.ubl.common;

public class PersonRepresentation {
    private String firstName;
    private String familyName;
    private String title;
    private String middleName;
    private String nameSuffix;
    private String jobTitle;
    private String organizationDepartment;
    private String id;

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameSuffix() {
        return this.nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getOrganizationDepartment() {
        return this.organizationDepartment;
    }

    public void setOrganizationDepartment(String organizationDepartment) {
        this.organizationDepartment = organizationDepartment;
    }
}