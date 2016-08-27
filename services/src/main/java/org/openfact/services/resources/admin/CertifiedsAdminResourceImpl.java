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
import org.openfact.services.util.CertificateUtil;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.CacheControl;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedsAdminResourceImpl implements CertifiedsAdminResource {

	private static final Logger logger = Logger.getLogger(CertifiedsAdminResourceImpl.class);
	
	/** The path to the folder where we want to store the uploaded files */
	public static final String UPLOADED_FILE_PARAMETER_NAME = "file";	
	private static final String UPLOAD_DIR = "/home/lxpary/uploadedFiles/";

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
					rep.getPassword(), rep.getValidity(), rep.isHasCertificate());

			URI uri = uriInfo.getAbsolutePathBuilder().path(certified.getId()).build();
			return Response.created(uri).entity(ModelToRepresentation.toRepresentation(certified)).build();
		} catch (ModelDuplicateException e) {
			if (session.getTransactionManager().isActive()) {
				session.getTransactionManager().setRollbackOnly();
			}
			return ErrorResponse.exists("Certified exists with same Alias");
		} catch (ModelException e) {
			if (session.getTransactionManager().isActive()) {
				session.getTransactionManager().setRollbackOnly();
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

	@Override
	public Response uploadCertified(MultipartFormDataInput input) {
		try {
			CertifiedModel certificate = session.certifieds().getCertifiedEnabled(organization);
			if (certificate != null) {
				System.out.println(">>>> sit back - starting file upload...");
				Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
				List<InputPart> inputParts = uploadForm.get(UPLOADED_FILE_PARAMETER_NAME);
				for (InputPart inputPart : inputParts) {
					MultivaluedMap<String, String> headers = inputPart.getHeaders();
					String filename = CertificateUtil.getFileName(headers);
					InputStream inputStream = inputPart.getBody(InputStream.class, null);
					byte[] bytes = IOUtils.toByteArray(inputStream);
					System.out
							.println(">>> File '{}' has been read, size: #{} bytes, " + filename + ", " + bytes.length);
					boolean write = CertificateUtil.writeFile(bytes, UPLOAD_DIR + filename);
					if (write) {
						certificate.setCertificate(UPLOAD_DIR + filename);
						certificate.setHasCertificate(true);
					}
				}
				return Response.status(Response.Status.OK).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}	

	@Override
	public CertifiedRepresentation getCertifiedEnabeld() {
		auth.requireView();
		CertifiedModel certified = session.certifieds().getCertifiedEnabled(organization);
		if (certified == null) {
			return null;
		}
		return ModelToRepresentation.toRepresentation(certified);
	}

}
