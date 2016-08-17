package org.openfact.services.resources.admin;

import org.apache.commons.io.IOUtils;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.*;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.CertifiedRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;

import javax.validation.Valid;
import javax.ws.rs.core.CacheControl;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import com.sun.jersey.core.header.FormDataContentDisposition;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedsAdminResourceImpl implements CertifiedsAdminResource {

	private static final Logger logger = Logger.getLogger(CertifiedsAdminResourceImpl.class);
	public static final String UPLOADED_FILE_PARAMETER_NAME = "file";

	protected OrganizationAuth auth;

	protected OrganizationModel organization;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected OpenfactSession session;

	@Context
	protected ClientConnection clientConnection;

	public CertifiedsAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth) {
		this.organization = organization;
		this.auth = auth;
		auth.init(OrganizationAuth.Resource.CERTIFIED);
	}

	public static final CacheControl noCache = new CacheControl();

	static {
		noCache.setNoCache(true);
	}

	@Override
	public CertifiedAdminResource getCertifiedAdmin(String certefiedId) {
		CertifiedModel certified = session.certifieds().getCertifiedById(certefiedId, organization);
		CertifiedAdminResource certifiedResource = new CertifiedAdminResourceImpl(auth, organization, certified);
		ResteasyProviderFactory.getInstance().injectProperties(certifiedResource);
		return certifiedResource;
	}

	@Override
	public List<CertifiedRepresentation> getCertifieds(String filterText, String alias, Integer firstResult,
			Integer maxResults) {
		auth.requireView();
		firstResult = firstResult != null ? firstResult : -1;
		maxResults = maxResults != null ? maxResults : -1;
		List<CertifiedRepresentation> results = new ArrayList<CertifiedRepresentation>();
		List<CertifiedModel> certifiedModels;
		if (filterText != null) {
			certifiedModels = session.certifieds().searchForCertified(filterText.trim(), organization, firstResult,
					maxResults);
		} else if (alias != null) {
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put("alias", alias);
			certifiedModels = session.certifieds().searchForCertifiedByAttributes(attributes, organization, firstResult,
					maxResults);
		} else {
			certifiedModels = session.certifieds().getCertifieds(organization, firstResult, maxResults);
		}
		certifiedModels.forEach(certifiedModel -> results.add(ModelToRepresentation.toRepresentation(certifiedModel)));
		return results;
	}

	@Override
	public Response createCertified(@Valid CertifiedRepresentation rep) {
		auth.requireManage();
		try {

			CertifiedModel certifiedEnable = session.certifieds().getCertifiedEnabled(organization);
			if (certifiedEnable != null) {
				certifiedEnable.disable();
			}
			CertifiedModel certified = session.certifieds().addCertified(organization, rep.getAlias(),
					rep.getCertificate(), rep.getPassword(), rep.getValidity());
			URI uri = uriInfo.getAbsolutePathBuilder().path(certified.getId()).build();
			return Response.created(uri).entity(ModelToRepresentation.toRepresentation(certified)).build();
		} catch (ModelDuplicateException e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().setRollbackOnly();
			}
			return ErrorResponse.exists("Certified exists with same Alias");
		} catch (ModelException e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().setRollbackOnly();
			}
			return ErrorResponse.exists("Could not create certified");
		}
	}

	@Override
	public SearchResultsRepresentation<CertifiedRepresentation> search(SearchCriteriaRepresentation criteria) {

		SearchCriteriaModel criteriaModel = new SearchCriteriaModel();

		Function<SearchCriteriaFilterOperatorRepresentation, SearchCriteriaFilterOperator> function = f -> {
			return SearchCriteriaFilterOperator.valueOf(f.toString());
		};
		criteria.getFilters().forEach(f -> {
			criteriaModel.addFilter(f.getName(), f.getValue(), function.apply(f.getOperator()));
		});
		criteria.getOrders().forEach(f -> criteriaModel.addOrder(f.getName(), f.isAscending()));
		PagingRepresentation paging = criteria.getPaging();
		criteriaModel.setPageSize(paging.getPageSize());
		criteriaModel.setPage(paging.getPage());

		String filterText = criteria.getFilterText();
		SearchResultsModel<CertifiedModel> results = null;
		if (filterText == null) {
			results = session.certifieds().search(organization, criteriaModel);
		} else {
			results = session.certifieds().search(organization, criteriaModel, filterText);
		}
		SearchResultsRepresentation<CertifiedRepresentation> rep = new SearchResultsRepresentation<>();
		List<CertifiedRepresentation> items = new ArrayList<>();
		results.getModels()
				.forEach(certifiedModel -> items.add(ModelToRepresentation.toRepresentation(certifiedModel)));
		rep.setItems(items);
		rep.setTotalSize(results.getTotalSize());
		return rep;

	}

	/** The path to the folder where we want to store the uploaded files */
	private static final String UPLOAD_DIR = "/home/lxpary/uploadedFiles/";

	private String data;

	@Override
	public Response uploadCertified(MultipartFormDataInput input) {

		System.out.println(">>>> sit back - starting file upload...");

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get(UPLOADED_FILE_PARAMETER_NAME);
		for (InputPart inputPart : inputParts) {
			MultivaluedMap<String, String> headers = inputPart.getHeaders();
			String filename = getFileName(headers);
			try {
				InputStream inputStream = inputPart.getBody(InputStream.class, null);
				byte[] bytes = IOUtils.toByteArray(inputStream);
				System.out.println(">>> File '{}' has been read, size: #{} bytes, " + filename + ", " + bytes.length);
				writeFile(bytes, UPLOAD_DIR + filename);
			} catch (IOException e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			}
		}
		return Response.status(Response.Status.OK).build();
	}

	private void writeFile(byte[] content, String filename) throws IOException {
		System.out.println(">>> writing #{} bytes to: {} " + content.length + " , " + filename);
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fop = new FileOutputStream(file);
		fop.write(content);
		fop.flush();
		fop.close();
		System.out.println(">>> writing complete: {} ::" + filename);
	}

	private String getFileName(MultivaluedMap<String, String> headers) {
		String[] contentDisposition = headers.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {
				String[] name = filename.split("=");
				String finalFileName = sanitizeFilename(name[1]);
				return finalFileName;
			}
		}
		return "unknown";
	}
	private String sanitizeFilename(String s) {
		return s.trim().replaceAll("\"", "");
	}

}
