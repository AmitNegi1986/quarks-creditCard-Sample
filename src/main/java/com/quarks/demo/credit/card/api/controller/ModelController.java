package com.quarks.demo.credit.card.api.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.quarks.demo.credit.card.api.exceptions.EntityNotFoundException;
import com.quarks.demo.credit.card.api.model.Model;
import com.quarks.demo.credit.card.api.service.ModelService;

@Path("/model")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class ModelController {

	@Inject
	ModelService modelService;

	@POST
	public Response create(Model model) {
		model = modelService.createModel(model);
		return Response.status(Status.CREATED).entity(model.id.toHexString()).build();
	}

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") String id) {
		Model entity = modelService.getModel(id);
		if (entity == null) {
			throw new EntityNotFoundException(String.valueOf(id));
		}
		return Response.ok(entity).build();
	}
}
