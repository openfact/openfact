package org.openfact.models;

import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.DocumentModel.RequiredAction;

import java.time.LocalDateTime;
import java.util.Arrays;

public class DocumentQueryModel {

    private final String filterText;
    private final Boolean enabled;
    private final LocalDateTime fromDate;
    private final LocalDateTime toDate;
    private boolean fromDateInclude;
    private boolean toDateInclude;
    private final String[] currencyCode;
    private final String[] type;
    private final String[] requiredAction;

    private DocumentQueryModel(Builder builder) {
        this.filterText = builder.filterText;
        this.enabled = builder.enabled;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
        this.fromDateInclude = builder.fromDateInclude;
        this.toDateInclude = builder.toDateInclude;
        this.currencyCode = builder.currencyCode;
        this.type = builder.type;
        this.requiredAction = builder.requiredAction;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFilterText() {
        return filterText;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public String[] getCurrencyCode() {
        return currencyCode;
    }

    public String[] getType() {
        return type;
    }

    public String[] getRequiredAction() {
        return requiredAction;
    }

    public boolean isFromDateInclude() {
        return fromDateInclude;
    }

    public boolean isToDateInclude() {
        return toDateInclude;
    }

    public static class Builder {

        private String filterText;
        private Boolean enabled;
        private LocalDateTime fromDate;
        private LocalDateTime toDate;
        private boolean fromDateInclude;
        private boolean toDateInclude;
        private String[] currencyCode;
        private String[] type;
        private String[] requiredAction;

        public Builder filterText(String filterText) {
            this.filterText = filterText;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder fromDate(LocalDateTime fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder fromDate(LocalDateTime fromDate, boolean include) {
            this.fromDate = fromDate;
            this.fromDateInclude = include;
            return this;
        }

        public Builder toDate(LocalDateTime toDate) {
            this.toDate = toDate;
            return this;
        }

        public Builder toDate(LocalDateTime toDate, boolean include) {
            this.toDate = toDate;
            this.toDateInclude = include;
            return this;
        }

        public Builder currencyCode(String... currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder type(String... type) {
            this.type = type;
            return this;
        }

        public Builder type(DocumentType... type) {
            this.type = Arrays.stream(type).map(Enum::toString).toArray(String[]::new);
            return this;
        }

        public Builder requiredAction(String... requiredAction) {
            this.requiredAction = requiredAction;
            return this;
        }

        public Builder requiredAction(RequiredAction... requiredAction) {
            this.requiredAction = Arrays.stream(requiredAction).map(Enum::toString).toArray(String[]::new);
            return this;
        }

        public DocumentQueryModel build() {
            return new DocumentQueryModel(this);
        }

    }

}