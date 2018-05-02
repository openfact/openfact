package org.openfact.core.models;

import java.util.Date;

public class DocumentBean {

    private final String type;
    private final String assignedId;
    private final Double amount;
    private final Double tax;
    private final String currency;
    private final Date issueDate;
    private final String customerName;
    private final String customerAssignedId;

    private DocumentBean(Builder builder) {
        this.type = builder.type;
        this.assignedId = builder.assignedId;
        this.amount = builder.amount;
        this.tax = builder.tax;
        this.currency = builder.currency;
        this.issueDate = builder.issueDate;
        this.customerName = builder.customerName;
        this.customerAssignedId = builder.customerAssignedId;
    }

    public String getType() {
        return type;
    }

    public String getAssignedId() {
        return assignedId;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getTax() {
        return tax;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAssignedId() {
        return customerAssignedId;
    }

    public static class Builder {
        private String type;
        private String assignedId;
        private Double amount;
        private Double tax;
        private String currency;
        private Date issueDate;
        private String customerName;
        private String customerAssignedId;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder assignedId(String assignedId) {
            this.assignedId = assignedId;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder tax(Double tax) {
            this.tax = tax;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder issueDate(Date issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder customerAssignedId(String customerAssignedId) {
            this.customerAssignedId = customerAssignedId;
            return this;
        }

        public DocumentBean build() {
            return new DocumentBean(this);
        }
    }
}
