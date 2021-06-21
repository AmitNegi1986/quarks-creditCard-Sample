package com.quarks.demo.credit.card.api.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.quarks.demo.credit.card.api.exceptions.EntityNotFoundException;
import com.quarks.demo.credit.card.api.model.Payment;
import com.quarks.demo.credit.card.api.service.PaymentService;
import com.quarks.demo.credit.card.api.util.ResourcePaths;


@Path(ResourcePaths.Payment.V3.ROOT)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class PaymentControllerV3 {

	@Inject
	PaymentService paymentService;

	@POST
	public Response doPayment( @Valid Payment payment) {
		Payment paymentEntity  = paymentService.doPayment(payment);
		return Response.status(Status.CREATED).entity(paymentEntity.id.toHexString()).build();		
	}

	
	@GET
	@Path(value = ResourcePaths.ID)
	public Response getPayment(@PathParam(value = "id") String id) {
		Payment paymentEntity = paymentService.getPayment(id);
		if (paymentEntity == null) {
			throw new EntityNotFoundException(String.valueOf(id));
		}
		System.err.println(paymentEntity.toString());
		
		return Response.ok(paymentEntity).build();
	}

}
