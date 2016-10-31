package org.openfact.models.jpa.entities.ubl.pe;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "SUMMARY_DOCUMENTS_ATTRIBUTE")
@NamedQueries({
        @NamedQuery(name = "getSummaryDocumentsAttributesByNameAndValue", query = "select attr from SummaryDocumentsAttributeEntity attr where attr.name = :name and attr.value = :value"),
        @NamedQuery(name = "deleteSummaryDocumentsAttributesByOrganization", query = "delete from  SummaryDocumentsAttributeEntity attr where attr.summaryDocuments IN (select u from SummaryDocumentsEntity u where u.organization.id=:organizationId)"),
        @NamedQuery(name = "deleteSummaryDocumentsAttributesByNameAndSummaryDocuments", query = "delete from  SummaryDocumentsAttributeEntity attr where attr.summaryDocuments.id = :summaryDocumentsId and attr.name = :name"),
        @NamedQuery(name = "deleteSummaryDocumentsAttributesOtherThan", query = "delete from  SummaryDocumentsAttributeEntity attr where attr.summaryDocuments.id = :summaryDocumentsId and attr.id <> :attrId") })

public class SummaryDocumentsAttributeEntity {
    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected SummaryDocumentsEntity summaryDocuments;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "VALUE")
    protected String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SummaryDocumentsEntity getSummaryDocuments() {
		return summaryDocuments;
	}

	public void setSummaryDocuments(SummaryDocumentsEntity summaryDocuments) {
		this.summaryDocuments = summaryDocuments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null)
	            return false;
	        if (!(o instanceof SummaryDocumentsAttributeEntity))
	            return false;

	        SummaryDocumentsAttributeEntity that = (SummaryDocumentsAttributeEntity) o;

	        if (!id.equals(that.getId()))
	            return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        return id.hashCode();
	    }
}
