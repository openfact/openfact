package org.openfact.services.resources.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.openfact.common.ClientConnection;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.email.freemarker.FreeMarkerEmailTemplateProvider;
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
import org.openfact.ubl.UblException;

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
		} catch (UblException e) {
            return ErrorResponse.exists("Ubl generation exeption");
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
	public Response executeActionsEmail(List<String> actions) {
		auth.requireManage();

		if (invoice == null) {
			return ErrorResponse.error("Invoice not found", Response.Status.NOT_FOUND);
		}

		if (invoice.getCustomer() == null || invoice.getCustomer().getEmail() == null) {
			return ErrorResponse.error("Customer email missing", Response.Status.BAD_REQUEST);
		}

		/*try {
			// UriBuilder builder =
			// Urls.executeActionsBuilder(uriInfo.getBaseUri());
			// builder.queryParam("key", accessCode.getCode());


			// audit.user(user).detail(Details.EMAIL,
			// user.getEmail()).detail(Details.CODE_ID,
			// accessCode.getCodeId()).success();

			return Response.ok().build();
		} catch (EmailException e) {
			logger.error("Failed to send actions email");
			return ErrorResponse.error("Failed to send execute actions email", Response.Status.INTERNAL_SERVER_ERROR);
		}*/

		 return Response.ok().build();
	}

	@Override
	public Response requiredActionGet() {
		Set<String> requiredActions = invoice.getRequiredActions();

		EmailTemplateProvider loginFormsProvider = session.getProvider(FreeMarkerEmailTemplateProvider.class);

        /*try {
            session.getProvider(EmailTemplateProvider.class)
            .setOrganization(organization)
            .setInvoice(invoice).sendVerifyEmail("", 1);
        } catch (EmailException e) {
            logger.error("Failed to send verification email", e);
            return Response.serverError().build();
        }*/
		/*try {
			session.getProvider(EmailTemplateProvider.class).setOrganization(organization).setInvoice(invoice).sendVerifyEmail("", 1);
		} catch (EmailException e) {
			logger.error("Failed to send verification email", e);
			return Response.serverError().build();
		}*/

		return Response.ok().build();
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
			FileOutputStream file = ReportUtil.getInvoicePDF(organization, invoice);
			// return Response.status(Response.Status.NOT_FOUND).build();

			ResponseBuilder response = Response.ok((Object) file);
			response.type("application/pdf");
			response.header("Content-Disposition",
					"attachment; filename=" + "Invoice_" + organization.getAssignedIdentificationId() + "_"
							+ invoice.getSeries() + "_" + invoice.getNumber() + ".pdf");
			return response.build();

		} catch (Exception e) {
			System.out.println("-------------------- PDF exception ");
			System.out.println(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response getXml() {
		// TODO Auto-generated method stub
		File file = new File(""); // Initialize this to the File path you want

		auth.requireView();
		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}

		//byte[] content = JsonXmlConverter.convertXmlToJson(invoice.getContent());

		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"") // optional
				.build();
	}

	@Override
	public Response getCdr() {
		// TODO Auto-generated method stub
		File file = new File(""); // Initialize this to the File path you want
		auth.requireView();
		if (invoice == null) {
			throw new NotFoundException("Invoice not found");
		}
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"") // optional
				.build();
	}

}
