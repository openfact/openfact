package org.openfact.email;

import java.util.Map;

public class EmailUserModel {

    private String fullName;
    private String email;
    private Map<String, String> attributes;

    public EmailUserModel(String email) {
        this.email = email;
    }

    public EmailUserModel(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public EmailUserModel(String email, String fullName, Map<String, String> attributes) {
        this.email = email;
        this.fullName = fullName;
        this.attributes = attributes;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
    
}
