package org.openfact.services.resources.admin;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.ModelReadOnlyException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.InvoiceLineRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.services.util.ReportUtil;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class InvoiceAdminResourceImpl implements InvoiceAdminResource {

	protected static final Logger logger = Logger.getLogger(InvoiceAdminResourceImpl.class);

	protected OrganizationModel organization;
	protected OrganizationAuth auth;
	protected InvoiceModel invoice;

	@Context
	protected OpenfactSession session;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected ClientConnection connection;

	public InvoiceAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, InvoiceModel invoice) {
		this.auth = auth;
		this.organization = organization;
		this.invoice = invoice;

		auth.init(OrganizationAuth.Resource.INVOICE);
		auth.requireAny();
	}

	@Override
	public InvoiceRepresentation getInvoice() {
		auth.requireView();

		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}
		return ModelToRepresentation.toRepresentation(invoice);
	}

	@Override
	public Response updateInvoice(InvoiceRepresentation rep) {
		auth.requireManage();

		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}

		try {
		    Set<String> attrsToRemove;
	        if (rep.getAttributes() != null) {
	            attrsToRemove = new HashSet<>(invoice.getAttributes().keySet());
	            attrsToRemove.removeAll(rep.getAttributes().keySet());
	        } else {
	            attrsToRemove = Collections.emptySet();
	        }
	        
			RepresentationToModel.updateInvoice(rep, attrsToRemove, invoice, session, true);
			return Response.noContent().build();
		} catch (ModelDuplicateException e) {
			return ErrorResponse.exists("Invoice exists with same serie and number");
		} catch (ModelReadOnlyException re) {
			return ErrorResponse.exists("Invoice is read only!");
		} catch (ModelException me) {
			return ErrorResponse.exists("Could not update invoice!");
		}

    }

    @Override
    public List<InvoiceLineRepresentation> getLines() {
        auth.requireView();

        return invoice.getInvoiceLines().stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @Override
    public Response deleteInvoice() {
        auth.requireManage();

        boolean removed = new InvoiceManager(session).removeInvoice(organization, invoice);
        if (removed) {
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Invoice couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }



	@Override
	public Response getPdf() {
		// TODO Auto-generated method stub
		try {

			auth.requireView();
			if (invoice == null) {
				throw new NotFoundException("Invoice not found");
			}
			InvoiceRepresentation rep = ModelToRepresentation.toRepresentation(invoice);

			File jrxmlFile = new File("/home/lxpary/report1.jrxml");
			if (jrxmlFile.exists()) {
				// jrxml compile
				JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile.getAbsolutePath());

				Collection<Map<String, ?>> list = ReportUtil.GetInvoiceCollection(rep);

				// detail section

				Random rd = new Random();
				for (int j = 0; j < 10; j++) {
					HashMap<String, Object> map2 = new HashMap<String, Object>();
					map2.put("COLUMN_0", rd.nextInt());
					map2.put("COLUMN_1", new StringBuilder().append(rd.nextInt()).append("foobar"));
					map2.put("COLUMN_2", rd.nextInt());
					map2.put("COLUMN_3", new StringBuilder().append(rd.nextInt()).append("app"));
					list.add(map2);
				}

				JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(list);
				HashMap<String, Object> params = new HashMap<String, Object>();
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
				// JasperViewer.viewReport(jasperPrint, false);

				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(
						new SimpleOutputStreamExporterOutput("Invoice_" + organization.getAssignedIdentificationId()
								+ "_" + rep.getInvoiceSeries() + "_" + rep.getInvoiceNumber() + ".pdf"));
				SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
				configuration.setMetadataAuthor("OpenFacturacion"); // why not
																	// set some
																	// config as
																	// we like
				exporter.setConfiguration(configuration);
				exporter.exportReport();

				/* this code is alternative to export */
				return Response.ok(exporter).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}

		} catch (Exception e) {
			System.out.println("-------------------- PDF exception ");
			System.out.println(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

}
