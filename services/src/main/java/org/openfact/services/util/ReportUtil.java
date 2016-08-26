package org.openfact.services.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceAdditionalInformationModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.InvoiceAdditionalInformationRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.InvoiceTaxTotalRepresentation;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportUtil {

	public static void GetInvoiceCollection(OrganizationModel organization, InvoiceModel invoice) {

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("Invoice_" + organization.getAssignedIdentificationId() + "_"
							+ invoice.getInvoiceId().getSeries() + "_" + invoice.getInvoiceId().getNumber() + ".pdf"));
			document.open();

			Image image = Image.getInstance("/home/lxpary/Imágenes/3519520.jpg");
			image.setAbsolutePosition(13f, 10f);
			image.scaleToFit(50f, 215f);
			document.add(image);

			PdfContentByte cb = new PdfContentByte(writer);
			cb.beginText();
			cb.setTextMatrix(12, 590);
			cb.showText(organization.getRegistrationName());
			cb.setTextMatrix(12, 580);
			cb.showText(organization.getPostalAddress().getCountrySubentity() + " "
					+ organization.getPostalAddress().getCountrySubentity() + " "
					+ organization.getPostalAddress().getDistrict());
			cb.setTextMatrix(12, 570);
			cb.showText(organization.getRegistrationName());
			cb.setTextMatrix(12, 560);
			cb.setLineWidth(0.5);
			cb.showText("CUSTOMER");

			cb.setTextMatrix(12, 550);
			cb.showText(invoice.getCustomer().getAssignedIdentificationId());
			cb.setTextMatrix(12, 540);
			cb.showText(invoice.getCustomer().getRegistrationName());
			// RIGHT
			cb.setTextMatrix(400, 600);
			cb.showText("RUC " + organization.getAssignedIdentificationId());
			cb.setTextMatrix(400, 590);
			cb.showText("FACTURA");
			cb.setTextMatrix(400, 680);
			cb.showText("ELECTRONICA");
			cb.setTextMatrix(400, 670);
			cb.showText("" + invoice.getInvoiceId().getSeries() + "-" + invoice.getInvoiceId().getNumber());
			cb.setTextMatrix(385, 550);
			cb.showText("ISSUE DATE :" + invoice.getIssueDate().toString());
			cb.setTextMatrix(385, 540);
			cb.showText("CURRENCY   :" + invoice.getCurrencyCode());

			cb.endText();

			PdfPTable table = new PdfPTable(6); // columns.
			// Set Column widths
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 0.5f, 1.0f, 1.0f, 5.0f, 1.0f, 1.5f });
			table.setSpacingBefore(10);

			// define font for table header row
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setColor(BaseColor.WHITE);

			// define table header cell
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.GRAY);
			cell.setPadding(5);

			// write table header
			cell.setPhrase(new Phrase("Order", font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Unit Code", font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Quantity", font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Description", font));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Price", font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Amount", font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			for (InvoiceLineModel map : invoice.getInvoiceLines()) {
				table.addCell(String.valueOf(map.getOrderNumber()));
				table.addCell(map.getUnitCode());
				table.addCell(String.valueOf(map.getQuantity()));
				table.addCell(map.getItemDescription());
				table.addCell(String.valueOf(map.getPrice()));
				table.addCell(String.valueOf(map.getAmount()));
			}
			document.add(table);

			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getInvoicePDF(OrganizationModel organization, InvoiceModel invoice) throws Exception {
		Document d = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(d,
					new FileOutputStream("Invoice_" + organization.getAssignedIdentificationId() + "_"
							+ invoice.getInvoiceId().getSeries() + "_" + invoice.getInvoiceId().getNumber() + ".pdf"));
			d.open();
			PdfPTable headerLeft = generateHeaderLeftTable(organization, invoice.getCustomer());
			PdfPTable headerRigth = generateHeaderRigthTable(organization, invoice);
			PdfPTable details = generateLineItemTable(invoice.getInvoiceLines());
			PdfPTable footerDetails = generateFooterDetailsTable(invoice);
			addBarcode(writer, organization.getAssignedIdentificationId());

			// add customer barcode to the header
			d.add(headerLeft);
			d.add(headerRigth);
			d.add(details);
			d.add(footerDetails);
			Paragraph p = new Paragraph("\n\nFor more, please visit ");
			Anchor anchor = new Anchor("www.openfact.com",
					FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.UNDERLINE));

			p.add(anchor);
			d.add(p);
			d.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static PdfPCell borderlessCell(String s) {
		PdfPCell cell = new PdfPCell();
		Font f = new Font();
		cell.setBorder(0);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.addElement(new Paragraph(s, f));
		return cell;
	}

	private static Image addBarcode(PdfWriter writer, String barCode) {
		PdfPTable table = new PdfPTable(2);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfContentByte cb = writer.getDirectContent();
		BarcodeEAN codeEAN = new BarcodeEAN();
		codeEAN.setCodeType(Barcode.EAN13);
		codeEAN.setCode(barCode);
		Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
		PdfPCell cell = new PdfPCell(imageEAN, false);
		cell.setPaddingTop(10);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(2);
		cell.setBorder(0);
		table.addCell(cell);
		return imageEAN;
	}

	/**
	 * @param listItems
	 * @return
	 * @throws DocumentException
	 */
	private static PdfPTable generateLineItemTable(List<InvoiceLineModel> listItems) throws DocumentException {

		PdfPTable table = new PdfPTable(6); // columns.
		table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		DecimalFormat df = new DecimalFormat("0.00");
		// Set Column widths
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 0.5f, 1.0f, 1.0f, 5.0f, 1.0f, 1.5f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Order", font));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Unit Code", font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Quantity", font));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Description", font));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Price", font));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Amount", font));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(cell);
		for (InvoiceLineModel map : listItems) {
			table.addCell(String.valueOf(map.getOrderNumber()));
			table.addCell(map.getUnitCode());
			table.addCell(df.format(map.getQuantity()));
			table.addCell(map.getItemDescription());
			table.addCell(df.format(map.getPrice()));
			table.addCell(df.format(map.getAmount()));
		}
		return table;
	}

	private static PdfPTable generateFooterDetailsTable(InvoiceModel invoice) throws DocumentException {
		PdfPTable table = new PdfPTable(2); // columns.
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		DecimalFormat df = new DecimalFormat("0.00");
		// Set Column widths
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 6.0f, 4.0f });
		table.setSpacingBefore(10);

		for (InvoiceAdditionalInformationModel elem : invoice.getAdditionalInformation()) {
			table.addCell(borderlessCell(elem.getDocument().getName()));
			table.addCell(borderlessCell(df.format(elem.getAmmount())));
		}
		for (InvoiceTaxTotalModel elem : invoice.getInvoiceTaxTotal()) {
			table.addCell(borderlessCell(elem.getDocument().getName()));
			table.addCell(borderlessCell(df.format(elem.getAmount())));
			table.addCell(borderlessCell(df.format(elem.getValue())));
		}

		return table;
	}

	private static PdfPTable generateHeaderLeftTable(OrganizationModel organization, CustomerModel customer)
			throws Exception {
		// Generic logo
		PdfPTable headerTable = new PdfPTable(2);
		headerTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		/*
		 * String imageUrl =
		 * "http://jenkov.com/images/20081123-20081123-3E1W7902-small-portrait.jpg";
		 * Image i = Image.getInstance(new URL(imageUrl));
		 */

		Image i = Image.getInstance("/home/lxpary/Imágenes/3519520.jpg");
		i.setAlignment(Element.ALIGN_RIGHT);
		i.scalePercent(25);

		PdfPCell cell = new PdfPCell(i, false);
		cell.setBorder(0);
		headerTable.addCell(cell);

		cell = borderlessCell("Code of Doom Order Form");
		headerTable.addCell(cell);
		headerTable.addCell(borderlessCell(organization.getRegistrationName()));
		headerTable.addCell(borderlessCell(organization.getPostalAddress().getCountrySubentity() + " "
				+ organization.getPostalAddress().getCountrySubentity() + " "
				+ organization.getPostalAddress().getDistrict()));
		headerTable.addCell(borderlessCell("CUSTOMER"));
		headerTable.addCell(borderlessCell(customer.getAssignedIdentificationId()));
		headerTable.addCell(borderlessCell(customer.getRegistrationName()));

		return headerTable;
	}

	private static PdfPTable generateHeaderRigthTable(OrganizationModel organization, InvoiceModel invoice)
			throws Exception {

		PdfPTable headerTable = new PdfPTable(1);
		headerTable.setHorizontalAlignment(Element.ALIGN_RIGHT);

		headerTable.addCell(borderlessCell(organization.getAssignedIdentificationId()));
		headerTable.addCell(borderlessCell("FACTURA"));
		headerTable.addCell(borderlessCell("ELECTRONICA"));
		headerTable
				.addCell(borderlessCell(invoice.getInvoiceId().getSeries() + "-" + invoice.getInvoiceId().getNumber()));
		headerTable.addCell(borderlessCell(invoice.getIssueDate().toString()));
		headerTable.addCell(borderlessCell(invoice.getCurrencyCode()));
		return headerTable;
	}

}
