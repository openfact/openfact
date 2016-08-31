package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.util.List;

public class DocumentRepresentation {

    private String id;
    private String name;
    private String documentId;
    private String description;
    private String type;

    private BigDecimal value;
    private Boolean checked;

    private String code;

    private String parent;
    private List<DocumentRepresentation> childrens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DocumentRepresentation> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<DocumentRepresentation> childrens) {
        this.childrens = childrens;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

}
