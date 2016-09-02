package org.openfact.services.resources.admin;


import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.openfact.representations.KeyStoreConfig;
import org.openfact.representations.idm.CertificateRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;



/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface CertificatesAdminResource {	

	/**
	 * Get key info
	 *
	 * @return
	 */
	@GET
	@NoCache
	@Produces(MediaType.APPLICATION_JSON)
	CertificateRepresentation getKeyInfo();

	/**
	 * Generate a new certificate with new key pair
	 *
	 * @return
	 */
	@POST
	@NoCache
	@Path("generate")
	@Produces(MediaType.APPLICATION_JSON)
	CertificateRepresentation generate();

	/**
	 * Upload certificate and eventually private key
	 *
	 * @param uriInfo
	 * @param input
	 * @return
	 * @throws IOException
	 */
	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	CertificateRepresentation uploadJks(@Context final UriInfo uriInfo, MultipartFormDataInput input);

	/**
	 * Upload only certificate, not private key
	 *
	 * @param uriInfo
	 * @param input
	 * @return information extracted from uploaded certificate - not necessarily
	 *         the new state of certificate on the server
	 * @throws IOException
	 */
	@POST
	@Path("upload-certificate")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	CertificateRepresentation uploadJksCertificate(@Context final UriInfo uriInfo, MultipartFormDataInput input);

	/**
	 * Get a keystore file for the client, containing private key and public
	 * certificate
	 *
	 * @param config
	 *            Keystore configuration as JSON
	 * @return
	 */
	@POST
	@NoCache
	@Path("/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Consumes(MediaType.APPLICATION_JSON)
	public byte[] getKeystore(final KeyStoreConfig config);

	/**
	 * Generate a new keypair and certificate, and get the private key file
	 *
	 * Generates a keypair and certificate and serves the private key in a
	 * specified keystore format. Only generated public certificate is saved in
	 * Keycloak DB - the private key is not.
	 *
	 * @param config
	 *            Keystore configuration as JSON
	 * @return
	 */
	@POST
	@NoCache
	@Path("/generate-and-download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Consumes(MediaType.APPLICATION_JSON)
	public byte[] generateAndGetKeystore(final KeyStoreConfig config);

}
