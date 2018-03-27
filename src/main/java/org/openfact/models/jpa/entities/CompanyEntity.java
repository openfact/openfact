package org.openfact.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Indexed
@Entity
@Table(name = "of_company")
@NamedQueries(value = {
        @NamedQuery(name = "getAllOwnedCompaniesByUserId", query = "select distinct c from  CompanyEntity c inner join c.owner u where u.id=:userId")
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.CompanyOwner", attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "owner", subgraph = "owner"),
        }, subgraphs = {
                @NamedSubgraph(name = "owner", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                })
        })
})
public class CompanyEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "use_custom_smtp_config")
    private boolean useCustomSmtpConfig;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "company_smtp_config", joinColumns = {@JoinColumn(name = "company_id")})
    private Map<String, String> smtpConfig = new HashMap<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey)
    private UserEntity owner;

    @Version
    @Column(name = "version")
    private int version;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
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

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompanyEntity)) {
            return false;
        }
        CompanyEntity other = (CompanyEntity) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public Map<String, String> getSmtpConfig() {
        return smtpConfig;
    }

    public void setSmtpConfig(Map<String, String> smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    public boolean isUseCustomSmtpConfig() {
        return useCustomSmtpConfig;
    }

    public void setUseCustomSmtpConfig(boolean useAdminSmtpConfig) {
        this.useCustomSmtpConfig = useAdminSmtpConfig;
    }
}