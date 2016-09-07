package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a telecommunications service (e.g., a telephone call or a
 * video on demand service).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:09 a. m.
 */
public class TelecommunicationsService {

	/**
	 * The amount to be payed as the base for one call
	 */
	private BigDecimal CallBaseAmount;
	/**
	 * In the case of a telephone call, the date of the call.
	 */
	private LocalDate CallDate;
	/**
	 * The amount to be payed for the call
	 */
	private BigDecimal CallExtensionAmount;
	/**
	 * In the case of a telephone call, the time of the call.
	 */
	private LocalTime CallTime;
	/**
	 * An identifier for this telecommunications service.
	 */
	private String ID;
	/**
	 * The title of a movie delivered via this telecommunications service.
	 */
	private String MovieTitle;
	/**
	 * A pay-per-view delivered via this telecommunications service.
	 */
	private String PayPerView;
	/**
	 * The number of calls.
	 */
	private BigDecimal Quantity;
	/**
	 * Statement of the roaming partner name.
	 */
	private String RoamingPartnerName;
	/**
	 * In the case of a telephone call, the phone number called.
	 */
	private String ServiceNumberCalled;
	/**
	 * The telecommunications call described as a text
	 */
	private String TelecommunicationsServiceCall;
	/**
	 * The telecommunications call described as a code
	 */
	private String TelecommunicationsServiceCallCode;
	/**
	 * The telecommunications category, expressed as text.
	 */
	private String TelecommunicationsServiceCategory;
	/**
	 * The telecommunications category, expressed as a code.
	 */
	private String TelecommunicationsServiceCategoryCode;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private Country m_Country;
	private Duty CallDuty;
	private Duty TimeDuty;
	private ExchangeRate m_ExchangeRate;
	private List<Price> prices = new ArrayList<>();
	private List<TaxTotal> taxTotals = new ArrayList<>();

	/**
	 * @return the callBaseAmount
	 */
	public BigDecimal getCallBaseAmount() {
		return CallBaseAmount;
	}

	/**
	 * @param callBaseAmount
	 *            the callBaseAmount to set
	 */
	public void setCallBaseAmount(BigDecimal callBaseAmount) {
		CallBaseAmount = callBaseAmount;
	}

	/**
	 * @return the callDate
	 */
	public LocalDate getCallDate() {
		return CallDate;
	}

	/**
	 * @param callDate
	 *            the callDate to set
	 */
	public void setCallDate(LocalDate callDate) {
		CallDate = callDate;
	}

	/**
	 * @return the callExtensionAmount
	 */
	public BigDecimal getCallExtensionAmount() {
		return CallExtensionAmount;
	}

	/**
	 * @param callExtensionAmount
	 *            the callExtensionAmount to set
	 */
	public void setCallExtensionAmount(BigDecimal callExtensionAmount) {
		CallExtensionAmount = callExtensionAmount;
	}

	/**
	 * @return the callTime
	 */
	public LocalTime getCallTime() {
		return CallTime;
	}

	/**
	 * @param callTime
	 *            the callTime to set
	 */
	public void setCallTime(LocalTime callTime) {
		CallTime = callTime;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the movieTitle
	 */
	public String getMovieTitle() {
		return MovieTitle;
	}

	/**
	 * @param movieTitle
	 *            the movieTitle to set
	 */
	public void setMovieTitle(String movieTitle) {
		MovieTitle = movieTitle;
	}

	/**
	 * @return the payPerView
	 */
	public String getPayPerView() {
		return PayPerView;
	}

	/**
	 * @param payPerView
	 *            the payPerView to set
	 */
	public void setPayPerView(String payPerView) {
		PayPerView = payPerView;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return Quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		Quantity = quantity;
	}

	/**
	 * @return the roamingPartnerName
	 */
	public String getRoamingPartnerName() {
		return RoamingPartnerName;
	}

	/**
	 * @param roamingPartnerName
	 *            the roamingPartnerName to set
	 */
	public void setRoamingPartnerName(String roamingPartnerName) {
		RoamingPartnerName = roamingPartnerName;
	}

	/**
	 * @return the serviceNumberCalled
	 */
	public String getServiceNumberCalled() {
		return ServiceNumberCalled;
	}

	/**
	 * @param serviceNumberCalled
	 *            the serviceNumberCalled to set
	 */
	public void setServiceNumberCalled(String serviceNumberCalled) {
		ServiceNumberCalled = serviceNumberCalled;
	}

	/**
	 * @return the telecommunicationsServiceCall
	 */
	public String getTelecommunicationsServiceCall() {
		return TelecommunicationsServiceCall;
	}

	/**
	 * @param telecommunicationsServiceCall
	 *            the telecommunicationsServiceCall to set
	 */
	public void setTelecommunicationsServiceCall(String telecommunicationsServiceCall) {
		TelecommunicationsServiceCall = telecommunicationsServiceCall;
	}

	/**
	 * @return the telecommunicationsServiceCallCode
	 */
	public String getTelecommunicationsServiceCallCode() {
		return TelecommunicationsServiceCallCode;
	}

	/**
	 * @param telecommunicationsServiceCallCode
	 *            the telecommunicationsServiceCallCode to set
	 */
	public void setTelecommunicationsServiceCallCode(String telecommunicationsServiceCallCode) {
		TelecommunicationsServiceCallCode = telecommunicationsServiceCallCode;
	}

	/**
	 * @return the telecommunicationsServiceCategory
	 */
	public String getTelecommunicationsServiceCategory() {
		return TelecommunicationsServiceCategory;
	}

	/**
	 * @param telecommunicationsServiceCategory
	 *            the telecommunicationsServiceCategory to set
	 */
	public void setTelecommunicationsServiceCategory(String telecommunicationsServiceCategory) {
		TelecommunicationsServiceCategory = telecommunicationsServiceCategory;
	}

	/**
	 * @return the telecommunicationsServiceCategoryCode
	 */
	public String getTelecommunicationsServiceCategoryCode() {
		return TelecommunicationsServiceCategoryCode;
	}

	/**
	 * @param telecommunicationsServiceCategoryCode
	 *            the telecommunicationsServiceCategoryCode to set
	 */
	public void setTelecommunicationsServiceCategoryCode(String telecommunicationsServiceCategoryCode) {
		TelecommunicationsServiceCategoryCode = telecommunicationsServiceCategoryCode;
	}

	/**
	 * @return the m_AllowanceCharge
	 */
	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	/**
	 * @param m_AllowanceCharge
	 *            the m_AllowanceCharge to set
	 */
	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	/**
	 * @return the m_Country
	 */
	public Country getM_Country() {
		return m_Country;
	}

	/**
	 * @param m_Country
	 *            the m_Country to set
	 */
	public void setM_Country(Country m_Country) {
		this.m_Country = m_Country;
	}

	/**
	 * @return the callDuty
	 */
	public Duty getCallDuty() {
		return CallDuty;
	}

	/**
	 * @param callDuty
	 *            the callDuty to set
	 */
	public void setCallDuty(Duty callDuty) {
		CallDuty = callDuty;
	}

	/**
	 * @return the timeDuty
	 */
	public Duty getTimeDuty() {
		return TimeDuty;
	}

	/**
	 * @param timeDuty
	 *            the timeDuty to set
	 */
	public void setTimeDuty(Duty timeDuty) {
		TimeDuty = timeDuty;
	}

	/**
	 * @return the m_ExchangeRate
	 */
	public ExchangeRate getM_ExchangeRate() {
		return m_ExchangeRate;
	}

	/**
	 * @param m_ExchangeRate
	 *            the m_ExchangeRate to set
	 */
	public void setM_ExchangeRate(ExchangeRate m_ExchangeRate) {
		this.m_ExchangeRate = m_ExchangeRate;
	}

	/**
	 * @return the m_Price
	 */
	public Price getM_Price() {
		return m_Price;
	}

	/**
	 * @param m_Price
	 *            the m_Price to set
	 */
	public void setM_Price(Price m_Price) {
		this.m_Price = m_Price;
	}

	/**
	 * @return the m_TaxTotal
	 */
	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	/**
	 * @param m_TaxTotal
	 *            the m_TaxTotal to set
	 */
	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}

}// end TelecommunicationsService