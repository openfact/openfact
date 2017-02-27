package org.openfact.rest.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.openfact.rest.dto.OrganizationEntityDTO;
import org.openfact.model.entities.OrganizationEntity;

/**
 * 
 */
@Stateless
@Path("/admin/organizations")
public class OrganizationAdminResource {
	@PersistenceContext(unitName = "openfact-persistence-unit")
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(OrganizationEntityDTO dto) {
		OrganizationEntity entity = dto.fromDTO(null, em);
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(OrganizationAdminResource.class).path(String.valueOf(entity.getId())).build())
				.build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		OrganizationEntity entity = em.find(OrganizationEntity.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<OrganizationEntity> findByIdQuery = em.createQuery(
				"SELECT DISTINCT o FROM OrganizationEntity o WHERE o.id = :entityId ORDER BY o.id",
				OrganizationEntity.class);
		findByIdQuery.setParameter("entityId", id);
		OrganizationEntity entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		OrganizationEntityDTO dto = new OrganizationEntityDTO(entity);
		return Response.ok(dto).build();
	}

	@GET
	@Produces("application/json")
	public List<OrganizationEntityDTO> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<OrganizationEntity> findAllQuery = em
				.createQuery("SELECT DISTINCT o FROM OrganizationEntity o ORDER BY o.id", OrganizationEntity.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<OrganizationEntity> searchResults = findAllQuery.getResultList();
		final List<OrganizationEntityDTO> results = new ArrayList<OrganizationEntityDTO>();
		for (OrganizationEntity searchResult : searchResults) {
			OrganizationEntityDTO dto = new OrganizationEntityDTO(searchResult);
			results.add(dto);
		}
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, OrganizationEntityDTO dto) {
		if (dto == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(dto.getId())) {
			return Response.status(Status.CONFLICT).entity(dto).build();
		}
		OrganizationEntity entity = em.find(OrganizationEntity.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		entity = dto.fromDTO(entity, em);
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Status.CONFLICT).entity(e.getEntity()).build();
		}
		return Response.noContent().build();
	}
}
