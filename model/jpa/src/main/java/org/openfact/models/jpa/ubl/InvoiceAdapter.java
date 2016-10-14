package org.openfact.models.jpa.ubl;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.InvoiceAttributeEntity;
import org.openfact.models.jpa.entities.ubl.InvoiceEntity;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.InvoiceLineEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentTermsEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.jpa.ubl.common.AllowanceChargeAdapter;
import org.openfact.models.jpa.ubl.common.BillingReferenceAdapter;
import org.openfact.models.jpa.ubl.common.CustomerPartyAdapter;
import org.openfact.models.jpa.ubl.common.DeliveryAdapter;
import org.openfact.models.jpa.ubl.common.DeliveryTermsAdapter;
import org.openfact.models.jpa.ubl.common.DocumentReferenceAdapter;
import org.openfact.models.jpa.ubl.common.ExchangeRateAdapter;
import org.openfact.models.jpa.ubl.common.InvoiceLineAdapter;
import org.openfact.models.jpa.ubl.common.MonetaryTotalAdapter;
import org.openfact.models.jpa.ubl.common.OrderReferenceAdapter;
import org.openfact.models.jpa.ubl.common.PartyAdapter;
import org.openfact.models.jpa.ubl.common.PaymentAdapter;
import org.openfact.models.jpa.ubl.common.PaymentMeansAdapter;
import org.openfact.models.jpa.ubl.common.PaymentTermsAdapter;
import org.openfact.models.jpa.ubl.common.PeriodAdapter;
import org.openfact.models.jpa.ubl.common.SignatureAdapter;
import org.openfact.models.jpa.ubl.common.SupplierPartyAdapter;
import org.openfact.models.jpa.ubl.common.TaxTotalAdapter;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DeliveryTermsModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.MonetaryTotalModel;
import org.openfact.models.ubl.common.OrderReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentMeansModel;
import org.openfact.models.ubl.common.PaymentModel;
import org.openfact.models.ubl.common.PaymentTermsModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.TaxTotalModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.utils.DocumentUtils;
import org.openfact.models.utils.OpenfactModelUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

	protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

	protected OrganizationModel organization;
	protected InvoiceEntity invoice;
	protected EntityManager em;
	protected OpenfactSession session;

	public InvoiceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			InvoiceEntity invoice) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.invoice = invoice;
	}

	@Override
	public InvoiceEntity getEntity() {
		return invoice;
	}

	@Override
	public UBLExtensionsModel getUBLExtensions() {
		return new UBLExtensionsAdapter(session, em, invoice.getUblExtensions());
	}

	@Override
	public void setUBLExtensions(UBLExtensionsModel value) {
		invoice.setUblExtensions(UBLExtensionsAdapter.toEntity(value, em));
	}

	@Override
	public String getUBLVersionID() {
		return invoice.getUblVersionID();
	}

	@Override
	public void setUBLVersionID(String value) {
		invoice.setUblVersionID(value);
	}

	@Override
	public String getCustomizationID() {
		return invoice.getCustomizationID();
	}

	@Override
	public void setCustomizationID(String value) {
		invoice.setCustomizationID(value);
	}

	@Override
	public String getProfileID() {
		return invoice.getProfileID();
	}

	@Override
	public void setProfileID(String value) {
		invoice.setProfileID(value);
	}

	@Override
	public String getID() {
		return invoice.getID();
	}

	@Override
	public void setID(String value) {
		invoice.setID(value);
	}

	@Override
	public boolean getCopyIndicator() {
		return invoice.isCopyIndicator();
	}

	@Override
	public void setCopyIndicator(boolean value) {
		invoice.setCopyIndicator(value);
	}

	@Override
	public String getUUID() {
		return invoice.getUuid();
	}

	@Override
	public void setUUID(String value) {
		invoice.setUuid(value);
	}

	@Override
	public LocalDate getIssueDate() {
		return invoice.getIssueDate();
	}

	@Override
	public void setIssueDate(LocalDate value) {
		invoice.setIssueDate(value);
	}

	@Override
	public LocalTime getIssueTime() {
		return invoice.getIssueTime();
	}

	@Override
	public void setIssueTime(LocalTime value) {
		invoice.setIssueTime(value);
	}

	@Override
	public String getInvoiceTypeCode() {
		return invoice.getInvoiceTypeCode();
	}

	@Override
	public void setInvoiceTypeCode(String value) {
		invoice.setInvoiceTypeCode(value);
	}

	@Override
	public List<String> getNote() {
		return invoice.getNote();
	}

	@Override
	public void setNote(List<String> note) {
		invoice.setNote(note);
	}

	@Override
	public LocalDate getTaxPointDate() {
		return invoice.getTaxPointDate();
	}

	@Override
	public void setTaxPointDate(LocalDate value) {
		invoice.setTaxPointDate(value);
	}

	@Override
	public String getDocumentCurrencyCode() {
		return invoice.getDocumentCurrencyCode();
	}

	@Override
	public void setDocumentCurrencyCode(String value) {
		invoice.setDocumentCurrencyCode(value);
	}

	@Override
	public String getTaxCurrencyCode() {
		return invoice.getTaxCurrencyCode();
	}

	@Override
	public void setTaxCurrencyCode(String value) {
		invoice.setTaxCurrencyCode(value);
	}

	@Override
	public String getPricingCurrencyCode() {
		return invoice.getPricingCurrencyCode();
	}

	@Override
	public void setPricingCurrencyCode(String value) {
		invoice.setPricingCurrencyCode(value);
	}

	@Override
	public String getPaymentCurrencyCode() {
		return invoice.getPaymentCurrencyCode();
	}

	@Override
	public void setPaymentCurrencyCode(String value) {
		invoice.setPaymentCurrencyCode(value);
	}

	@Override
	public String getPaymentAlternativeCurrencyCode() {
		return invoice.getPaymentAlternativeCurrencyCode();
	}

	@Override
	public void setPaymentAlternativeCurrencyCode(String value) {
		invoice.setPaymentAlternativeCurrencyCode(value);
	}

	@Override
	public String getAccountingCostCode() {
		return invoice.getAccountingCostCode();
	}

	@Override
	public void setAccountingCostCode(String value) {
		invoice.setAccountingCostCode(value);
	}

	@Override
	public String getAccountingCost() {
		return invoice.getAccountingCost();
	}

	@Override
	public void setAccountingCost(String value) {
		invoice.setAccountingCost(value);
	}

	@Override
	public BigDecimal getLineCountNumeric() {
		return invoice.getLineCountNumeric();
	}

	@Override
	public void setLineCountNumeric(BigDecimal value) {
		invoice.setLineCountNumeric(value);
	}

	@Override
	public List<PeriodModel> getInvoicePeriod() {
		return invoice.getInvoicePeriod().stream().map(f -> new PeriodAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoicePeriod(List<PeriodModel> invoicePeriod) {
		List<PeriodEntity> entities = invoicePeriod.stream().map(f -> PeriodAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setInvoicePeriod(entities);
	}

	@Override
	public OrderReferenceModel getOrderReference() {
		return new OrderReferenceAdapter(session, em, invoice.getOrderReference());
	}

	@Override
	public void setOrderReference(OrderReferenceModel value) {
		invoice.setOrderReference(OrderReferenceAdapter.toEntity(value, em));
	}

	@Override
	public List<BillingReferenceModel> getBillingReference() {
		return invoice.getBillingReference().stream().map(f -> new BillingReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setBillingReference(List<BillingReferenceModel> billingReference) {
		List<BillingReferenceEntity> entities = billingReference.stream()
				.map(f -> BillingReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		invoice.setBillingReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getDespatchDocumentReference() {
		return invoice.getDespatchDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDespatchDocumentReference(List<DocumentReferenceModel> despatchDocumentReference) {
		List<DocumentReferenceEntity> entities = despatchDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		invoice.setDespatchDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getReceiptDocumentReference() {
		return invoice.getReceiptDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setReceiptDocumentReference(List<DocumentReferenceModel> receiptDocumentReference) {
		List<DocumentReferenceEntity> entities = receiptDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		invoice.setDespatchDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getOriginatorDocumentReference() {
		return invoice.getOriginatorDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setOriginatorDocumentReference(List<DocumentReferenceModel> originatorDocumentReference) {
		List<DocumentReferenceEntity> entities = originatorDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		invoice.setOriginatorDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getContractDocumentReference() {
		return invoice.getContractDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setContractDocumentReference(List<DocumentReferenceModel> contractDocumentReference) {
		List<DocumentReferenceEntity> entities = contractDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		invoice.setContractDocumentReference(entities);
	}

	@Override
	public List<DocumentReferenceModel> getAdditionalDocumentReference() {
		return invoice.getContractDocumentReference().stream().map(f -> new DocumentReferenceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setAdditionalDocumentReference(List<DocumentReferenceModel> additionalDocumentReference) {
		List<DocumentReferenceEntity> entities = additionalDocumentReference.stream()
				.map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
		invoice.setContractDocumentReference(entities);
	}

	@Override
	public List<SignatureModel> getSignature() {
		return invoice.getSignature().stream().map(f -> new SignatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setSignature(List<SignatureModel> signature) {
		List<SignatureEntity> entities = signature.stream().map(f -> SignatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setSignature(entities);
	}

	@Override
	public SupplierPartyModel getAccountingSupplierParty() {
		return new SupplierPartyAdapter(session, em, invoice.getAccountingSupplierParty());
	}

	@Override
	public void setAccountingSupplierParty(SupplierPartyModel value) {
		invoice.setAccountingSupplierParty(SupplierPartyAdapter.toEntity(value, em));
	}

	@Override
	public CustomerPartyModel getAccountingCustomerParty() {
		return new CustomerPartyAdapter(session, em, invoice.getAccountingCustomerParty());
	}

	@Override
	public void setAccountingCustomerParty(CustomerPartyModel value) {
		invoice.setAccountingCustomerParty(CustomerPartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getPayeeParty() {
		return new PartyAdapter(session, em, invoice.getPayeeParty());
	}

	@Override
	public void setPayeeParty(PartyModel value) {
		invoice.setPayeeParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public CustomerPartyModel getBuyerCustomerParty() {
		return new CustomerPartyAdapter(session, em, invoice.getBuyerCustomerParty());
	}

	@Override
	public void setBuyerCustomerParty(CustomerPartyModel value) {
		invoice.setBuyerCustomerParty(CustomerPartyAdapter.toEntity(value, em));
	}

	@Override
	public SupplierPartyModel getSellerSupplierParty() {
		return new SupplierPartyAdapter(session, em, invoice.getSellerSupplierParty());
	}

	@Override
	public void setSellerSupplierParty(SupplierPartyModel value) {
		invoice.setSellerSupplierParty(SupplierPartyAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getTaxRepresentativeParty() {
		return new PartyAdapter(session, em, invoice.getTaxRepresentativeParty());
	}

	@Override
	public void setTaxRepresentativeParty(PartyModel value) {
		invoice.setTaxRepresentativeParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public List<DeliveryModel> getDelivery() {
		return invoice.getDelivery().stream().map(f -> new DeliveryAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDelivery(List<DeliveryModel> delivery) {
		List<DeliveryEntity> entities = delivery.stream().map(f -> DeliveryAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setDelivery(entities);
	}

	@Override
	public DeliveryTermsModel getDeliveryTerms() {
		return new DeliveryTermsAdapter(session, em, invoice.getDeliveryTerms());
	}

	@Override
	public void setDeliveryTerms(DeliveryTermsModel value) {
		invoice.setDeliveryTerms(DeliveryTermsAdapter.toEntity(value, em));
	}

	@Override
	public List<PaymentMeansModel> getPaymentMeans() {
		return invoice.getPaymentMeans().stream().map(f -> new PaymentMeansAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setPaymentMeans(List<PaymentMeansModel> paymentMeans) {
		List<PaymentMeansEntity> entities = paymentMeans.stream().map(f -> PaymentMeansAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setPaymentMeans(entities);
	}

	@Override
	public List<PaymentTermsModel> getPaymentTerms() {
		return invoice.getPaymentTerms().stream().map(f -> new PaymentTermsAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setPaymentTerms(List<PaymentTermsModel> paymentTerms) {
		List<PaymentTermsEntity> entities = paymentTerms.stream().map(f -> PaymentTermsAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setPaymentTerms(entities);
	}

	@Override
	public List<PaymentModel> getPrepaidPayment() {
		return invoice.getPrepaidPayment().stream().map(f -> new PaymentAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setPrepaidPayment(List<PaymentModel> prepaidPayment) {
		List<PaymentEntity> entities = prepaidPayment.stream().map(f -> PaymentAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setPrepaidPayment(entities);
	}

	@Override
	public List<AllowanceChargeModel> getAllowanceCharge() {
		return invoice.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge) {
		List<AllowanceChargeEntity> entities = allowanceCharge.stream().map(f -> AllowanceChargeAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setAllowanceCharge(entities);
	}

	@Override
	public ExchangeRateModel getTaxExchangeRate() {
		return new ExchangeRateAdapter(session, em, invoice.getTaxExchangeRate());
	}

	@Override
	public void setTaxExchangeRate(ExchangeRateModel value) {
		invoice.setTaxExchangeRate(ExchangeRateAdapter.toEntity(value, em));
	}

	@Override
	public ExchangeRateModel getPricingExchangeRate() {
		return new ExchangeRateAdapter(session, em, invoice.getPricingExchangeRate());
	}

	@Override
	public void setPricingExchangeRate(ExchangeRateModel value) {
		invoice.setPricingExchangeRate(ExchangeRateAdapter.toEntity(value, em));
	}

	@Override
	public ExchangeRateModel getPaymentExchangeRate() {
		return new ExchangeRateAdapter(session, em, invoice.getPaymentExchangeRate());
	}

	@Override
	public void setPaymentExchangeRate(ExchangeRateModel value) {
		invoice.setPaymentExchangeRate(ExchangeRateAdapter.toEntity(value, em));
	}

	@Override
	public ExchangeRateModel getPaymentAlternativeExchangeRate() {
		return new ExchangeRateAdapter(session, em, invoice.getPaymentAlternativeExchangeRate());
	}

	@Override
	public void setPaymentAlternativeExchangeRate(ExchangeRateModel value) {
		invoice.setPaymentAlternativeExchangeRate(ExchangeRateAdapter.toEntity(value, em));
	}

	@Override
	public List<TaxTotalModel> getTaxTotal() {
		return invoice.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setTaxTotal(List<TaxTotalModel> taxTotal) {
		List<TaxTotalEntity> entities = taxTotal.stream().map(f -> TaxTotalAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setTaxTotal(entities);
	}

	@Override
	public MonetaryTotalModel getLegalMonetaryTotal() {
		return new MonetaryTotalAdapter(session, em, invoice.getLegalMonetaryTotal());
	}

	@Override
	public void setLegalMonetaryTotal(MonetaryTotalModel value) {
		invoice.setLegalMonetaryTotal(MonetaryTotalAdapter.toEntity(value, em));
	}

	@Override
	public List<InvoiceLineModel> getInvoiceLine() {
		return invoice.getInvoiceLine().stream().map(f -> new InvoiceLineAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoiceLine(List<InvoiceLineModel> invoiceLine) {
		List<InvoiceLineEntity> entities = invoiceLine.stream().map(f -> InvoiceLineAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		invoice.setInvoiceLine(entities);
	}

	@Override
	public String getId() {
		return invoice.getId();
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		String firstExistingAttrId = null;
		List<InvoiceAttributeEntity> toRemove = new ArrayList<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				if (firstExistingAttrId == null) {
					attr.setValue(value);
					firstExistingAttrId = attr.getId();
				} else {
					toRemove.add(attr);
				}
			}
		}

		if (firstExistingAttrId != null) {
			// Remove attributes through HQL to avoid StaleUpdateException
			Query query = em.createNamedQuery("deleteInvoiceAttributesOtherThan");
			query.setParameter("attrId", firstExistingAttrId);
			query.setParameter("invoiceId", invoice.getId());
			int numUpdated = query.executeUpdate();

			// Remove attribute from local entity
			invoice.getAttributes().removeAll(toRemove);
		} else {

			persistAttributeValue(name, value);
		}
	}

	@Override
	public void setAttribute(String name, List<String> values) {
		// Remove all existing
		removeAttribute(name);

		// Put all new
		for (String value : values) {
			persistAttributeValue(name, value);
		}
	}

	private void persistAttributeValue(String name, String value) {
		InvoiceAttributeEntity attr = new InvoiceAttributeEntity();
		attr.setId(OpenfactModelUtils.generateId());
		attr.setName(name);
		attr.setValue(value);
		attr.setInvoice(invoice);
		em.persist(attr);
		invoice.getAttributes().add(attr);
	}

	@Override
	public void removeAttribute(String name) {
		// KEYCLOAK-3296 : Remove attribute through HQL to avoid
		// StaleUpdateException
		Query query = em.createNamedQuery("deleteInvoiceAttributesByNameAndInvoice");
		query.setParameter("name", name);
		query.setParameter("invoiceId", invoice.getId());
		int numUpdated = query.executeUpdate();

		// Also remove attributes from local invoice entity
		List<InvoiceAttributeEntity> toRemove = new ArrayList<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				toRemove.add(attr);
			}
		}
		invoice.getAttributes().removeAll(toRemove);
	}

	@Override
	public String getFirstAttribute(String name) {
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				return attr.getValue();
			}
		}
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> result = new ArrayList<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			if (attr.getName().equals(name)) {
				result.add(attr.getValue());
			}
		}
		return result;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
		for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
			result.add(attr.getName(), attr.getValue());
		}
		return result;
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, invoice.getOrganization());
	}

	@Override
	public InvoiceLineModel addInvoiceLine() {
		List<InvoiceLineEntity> entities = invoice.getInvoiceLine();

		InvoiceLineEntity entity = new InvoiceLineEntity();
		entities.add(entity);
		return new InvoiceLineAdapter(session, em, entity);
	}

	@Override
	public TaxTotalModel addTaxTotal() {
		List<TaxTotalEntity> entities = invoice.getTaxTotal();

		TaxTotalEntity entity = new TaxTotalEntity();
		entities.add(entity);
		return new TaxTotalAdapter(session, em, entity);
	}

	@Override
	public SignatureModel addSignature() {
		List<SignatureEntity> entities = invoice.getSignature();

		SignatureEntity entity = new SignatureEntity();
		entities.add(entity);
		return new SignatureAdapter(session, em, entity);
	}

	@Override
	public byte[] getXmlDoument() {
		return this.invoice.getXmlDocument();
	}

	@Override
	public void setXmlDocument(byte[] xmlDocument) {
		this.invoice.setXmlDocument(xmlDocument);
	}

}
