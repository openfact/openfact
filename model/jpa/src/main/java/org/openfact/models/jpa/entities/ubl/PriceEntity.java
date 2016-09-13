package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.RateType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a price, expressed in a data structure containing
 * multiple properties (compare with UnstructuredPrice).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
@Entity
@Table(name = "PRICE")
public class PriceEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The quantity at which this price applies.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BASEQUANTITY_VALUE")),
			@AttributeOverride(name = "unitCode", column = @Column(name = "BASEQUANTITY_UNITCODE")) })
	private QuantityType baseQuantity;
	/**
	 * The factor by which the base price unit can be converted to the orderable
	 * unit.
	 */
	@Transient
	private RateType orderableUnitFactorRate;
	/**
	 * The amount of the price.
	 */
	@Column(name = "PRICE_AMOUNT")
	private BigDecimal priceAmount;
	/**
	 * A reason for a price change.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PRICECHANGEREASON_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PRICECHANGEREASON_LANGUAGEID")) })
	private TextType priceChangeReason;
	/**
	 * The type of price, expressed as text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PRICETYPE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PRICETYPE_LANGUAGEID")) })
	private TextType priceType;
	/**
	 * The type of price, expressed as a code.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PRICETYPECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "PRICETYPECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "PRICETYPECODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "PRICETYPECODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "PRICETYPECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "PRICETYPECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "PRICETYPECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PRICETYPECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "PRICETYPECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "PRICETYPECODE_LISTSCHEMEURI")) })
	private CodeType priceTypeCode;
	@Transient
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
	@Transient
	private ExchangeRateEntity pricingExchangeRate;
	@Transient
	private PeriodEntity validityPeriod;
	@Transient
	private List<PriceListEntity> priceLists = new ArrayList<>();
	
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public QuantityType getBaseQuantity() {
		return baseQuantity;
	}
	public void setBaseQuantity(QuantityType baseQuantity) {
		this.baseQuantity = baseQuantity;
	}
	public RateType getOrderableUnitFactorRate() {
		return orderableUnitFactorRate;
	}
	public void setOrderableUnitFactorRate(RateType orderableUnitFactorRate) {
		this.orderableUnitFactorRate = orderableUnitFactorRate;
	}
	public BigDecimal getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(BigDecimal priceAmount) {
		this.priceAmount = priceAmount;
	}
	public TextType getPriceChangeReason() {
		return priceChangeReason;
	}
	public void setPriceChangeReason(TextType priceChangeReason) {
		this.priceChangeReason = priceChangeReason;
	}
	public TextType getPriceType() {
		return priceType;
	}
	public void setPriceType(TextType priceType) {
		this.priceType = priceType;
	}
	public CodeType getPriceTypeCode() {
		return priceTypeCode;
	}
	public void setPriceTypeCode(CodeType priceTypeCode) {
		this.priceTypeCode = priceTypeCode;
	}
	public List<AllowanceChargeEntity> getAllowanceCharges() {
		return allowanceCharges;
	}
	public void setAllowanceCharges(List<AllowanceChargeEntity> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}
	public ExchangeRateEntity getPricingExchangeRate() {
		return pricingExchangeRate;
	}
	public void setPricingExchangeRate(ExchangeRateEntity pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}
	public PeriodEntity getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(PeriodEntity validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	public List<PriceListEntity> getPriceLists() {
		return priceLists;
	}
	public void setPriceLists(List<PriceListEntity> priceLists) {
		this.priceLists = priceLists;
	}	

}
