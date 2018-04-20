package org.openfact.core.models.jpa.entities;

import org.apache.lucene.analysis.core.KeywordTokenizerFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.miscellaneous.WordDelimiterFilterFactory;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.pattern.PatternReplaceFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Indexed
@Cacheable
@Entity
@Table(name = "cn_document", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"type", "assigned_id", "supplier_assigned_id"})
})
@NamedQueries({
        @NamedQuery(name = "getAllDocuments", query = "select d from DocumentEntity d"),
        @NamedQuery(name = "getDocumentByTypeAssignedIdAndSupplierAssignedId", query = "select d from DocumentEntity d where d.type = :type and d.assignedId = :assignedId and d.supplierAssignedId =:supplierAssignedId")
})
@AnalyzerDefs(value = {
        @AnalyzerDef(
                name = "standardAnalyzer",
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
                filters = {
                        @TokenFilterDef(factory = WordDelimiterFilterFactory.class),
                        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                        @TokenFilterDef(factory = PatternReplaceFilterFactory.class, params = {
                                @Parameter(name = "pattern", value = "([^a-zA-Z0-9\\.])"),
                                @Parameter(name = "replacement", value = " "),
                                @Parameter(name = "pattern", value = "all")
                        })
                }
        ),
        @AnalyzerDef(
                name = "autocompleteNGramAnalyzer",
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
                filters = {
                        @TokenFilterDef(factory = WordDelimiterFilterFactory.class),
                        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                        @TokenFilterDef(factory = NGramFilterFactory.class, params = {
                                @Parameter(name = "minGramSize", value = "3"),
                                @Parameter(name = "maxGramSize", value = "5")
                        }),
                        @TokenFilterDef(factory = PatternReplaceFilterFactory.class, params = {
                                @Parameter(name = "pattern", value = "([^a-zA-Z0-9\\.])"),
                                @Parameter(name = "replacement", value = " "),
                                @Parameter(name = "pattern", value = "all")
                        })
                }
        ),
        @AnalyzerDef(
                name = "autocompleteEdgeAnalyzer",
                tokenizer = @TokenizerDef(factory = KeywordTokenizerFactory.class),
                filters = {
                        @TokenFilterDef(factory = PatternReplaceFilterFactory.class, params = {
                                @Parameter(name = "pattern", value = "([^a-zA-Z0-9\\.])"),
                                @Parameter(name = "replacement", value = " "),
                                @Parameter(name = "pattern", value = "all")
                        }),
                        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                        @TokenFilterDef(factory = StopFilterFactory.class),
                        @TokenFilterDef(factory = EdgeNGramFilterFactory.class, params = {
                                @Parameter(name = "minGramSize", value = "3"),
                                @Parameter(name = "maxGramSize", value = "50")
                        })
                }
        )
})
public class DocumentEntity implements Serializable {

    @Id
    @DocumentId
    @Access(AccessType.PROPERTY)// Relationships often fetch id, but not entity.  This avoids an extra SQL
    @Column(name = "id", length = 36)
    private String id;

    @Facet
    @Field(analyze = Analyze.NO)
    @NotNull
    @Column(name = "type")
    private String type;

    @SortableField(forField = "assignedId")
    @Fields(value = {
            @Field(name = "assignedId", analyze = Analyze.NO),
            @Field(name = "nGramAssignedId", analyzer = @Analyzer(definition = "autocompleteNGramAnalyzer")),
            @Field(name = "edgeNGramAssignedId", analyzer = @Analyzer(definition = "autocompleteEdgeAnalyzer"))
    })
    @NotNull
    @Column(name = "assigned_id")
    private String assignedId;

    @Field(analyze = Analyze.NO)
    @NotNull
    @Column(name = "supplier_assigned_id")
    private String supplierAssignedId;

    @Field(analyze = Analyze.NO)
    @NotNull
    @Column(name = "supplier_name")
    private String supplierName;

    @Field(analyzer = @Analyzer(definition = "standardAnalyzer"))
    @Column(name = "customer_assigned_id")
    private String customerAssignedId;

    @Fields(value = {
            @Field(name = "customerName", store = Store.YES, analyzer = @Analyzer(definition = "standardAnalyzer")),
            @Field(name = "nGramCustomerName", analyzer = @Analyzer(definition = "autocompleteNGramAnalyzer")),
            @Field(name = "edgeNGramCustomerName", analyzer = @Analyzer(definition = "autocompleteEdgeAnalyzer"))
    })
    @Column(name = "customer_name")
    private String customerName;

    @Facet
    @Field(analyze = Analyze.NO)
    @Column(name = "currency")
    private String currency;

    @SortableField(forField = "issueDate")
    @NumericField(forField = "issueDate")
    @DateBridge(resolution = Resolution.MILLISECOND)
    @Facet(forField = "issueDateFacet", encoding = FacetEncodingType.LONG)
    @Fields(value = {
            @Field(name = "issueDate", analyze = Analyze.NO),
            @Field(name = "issueDateFacet", analyze = Analyze.NO)
    })
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "issue_date")
    private Date issueDate;

    @SortableField(forField = "amount")
    @Facet(forField = "amountFacet", encoding = FacetEncodingType.LONG)
    @Fields(value = {
            @Field(name = "amount", analyze = Analyze.NO),
            @Field(name = "amountFacet", analyze = Analyze.NO)
    })
    @Digits(integer = 10, fraction = 4)
    @Type(type = "org.hibernate.type.DoubleType")
    @Column(name = "amount")
    private Double amount;

    @Field(analyze = Analyze.NO)
    @Digits(integer = 10, fraction = 4)
    @Type(type = "org.hibernate.type.DoubleType")
    @Column(name = "tax")
    private Double tax;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public String getSupplierAssignedId() {
        return supplierAssignedId;
    }

    public void setSupplierAssignedId(String supplierAssignedId) {
        this.supplierAssignedId = supplierAssignedId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCustomerAssignedId() {
        return customerAssignedId;
    }

    public void setCustomerAssignedId(String customerAssignedId) {
        this.customerAssignedId = customerAssignedId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}

