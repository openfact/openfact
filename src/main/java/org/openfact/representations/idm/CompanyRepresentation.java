package org.openfact.representations.idm;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class CompanyRepresentation {

    private String id;
    private String name;
    private String description;

    private Boolean useCustomSmtpConfig;
    private Map<String, String> smtpServer;

    @NotNull
    private CompanyOwnerRepresentation owner;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompanyOwnerRepresentation getOwner() {
        return owner;
    }

    public void setOwner(CompanyOwnerRepresentation owner) {
        this.owner = owner;
    }

    public Map<String, String> getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(Map<String, String> smtpServer) {
        this.smtpServer = smtpServer;
    }

    public Boolean getUseCustomSmtpConfig() {
        return useCustomSmtpConfig;
    }

    public void setUseCustomSmtpConfig(Boolean useCustomSmtpConfig) {
        this.useCustomSmtpConfig = useCustomSmtpConfig;
    }

    public static class CompanyOwnerRepresentation {

        @NotNull
        private String id;
        private String identityId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }
    }
}
