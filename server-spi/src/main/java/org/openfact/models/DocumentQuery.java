package org.openfact.models;

import java.time.LocalDateTime;

public class DocumentQuery {

    private final String filterText;
    private final Boolean enabled;
    private final LocalDateTime fromDate;
    private final LocalDateTime toDate;
    private final String[] currencyCode;
    private final String[] type;
    private final String[] requiredAction;

    private DocumentQuery(Builder builder) {
        this.filterText = builder.filterText;
        this.enabled = builder.enabled;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
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

    public static class Builder {

        private String filterText;
        private Boolean enabled;
        private LocalDateTime fromDate;
        private LocalDateTime toDate;
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

        public Builder toDate(LocalDateTime toDate) {
            this.toDate = toDate;
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

        public Builder requiredAction(String... requiredAction) {
            this.requiredAction = requiredAction;
            return this;
        }

        public DocumentQuery build() {
            return new DocumentQuery(this);
        }

    }

}