package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.services.BankService;

import io.swagger.annotations.Api;

@Api(
		tags = {"Branches"},
		consumes = MediaType.APPLICATION_JSON,
		produces = MediaType.APPLICATION_JSON
	)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BranchResource {

	/**
	 * get all the banks belongs to a particular branch
	 * @param bankId
	 * @return
	 */
	@GET
	public Response getBranches(@PathParam("bankId") int bankId) {
		BankService service = new BankService();
		return Response.ok(service.getBranches(bankId)).build();
	}
	
}
