package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.model.dto.BankDTO;
import org.pensions.md.services.BankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		tags = {"Banks"},
		consumes = MediaType.APPLICATION_JSON,
		produces = MediaType.APPLICATION_JSON
	)
@Path("/banks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankResource {

	/**
	 * get all banks
	 * @return
	 */
	@ApiOperation(value = "Get all banks",
			notes = "Get all banks",
			response = BankDTO.class, 
			responseContainer = "List",
			code = 200
			)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "no banks found")
	})
	@GET
	public Response getBanks() {
		
		return Response.ok(
				new BankService().getAllBanks()
				).build();
	}
	
	/**
	 * get a particular bank
	 * @param bankId
	 * @return
	 */
	@GET
	@Path("/{bankId}")
	public Response getBank(@PathParam("bankId") Integer bankId) {
		BankService service = new BankService();
		BankDTO bank = service.getBank(bankId);
		return Response.ok(bank).build();
	}
	
	/*
	 * Get all branches of a bank
	 */
	@Path("/{bankId}/branches")
	public BranchResource goToBranchResource() {
		return new BranchResource();
	}
	
	/*
	 * Branch details
	 * @param bankId branch id which wants the details
	 */
	@GET
	@Path("/branches/{brnach}")
	public Response getBrnches(@PathParam("brnach") int branchId) {
		BankService service = new BankService();
		return Response.ok(service.getBranch(branchId)).build();
	}
	
	/**
	 * Add new bank
	 * @param bank
	 * @return
	 */
	@PUT
	public Response addNewBank() {
		return Response.ok().build();
	}
	
	/**
	 * Update bank detail
	 * @param bank
	 * @return
	 */
	@POST
	@Path("/{bankId}")
	public Response updateBank() {
		return Response.ok().build();
	}
	
	
	/**
	 * delete a bank
	 * @param bankId
	 * @return
	 */
	@DELETE
	@Path("/{bankId}")
	public Response deleteBank(@PathParam("bankId") int bankId) {
		return Response.ok(String.valueOf(bankId)).build();
	}
	
	/******************Bank branch updating resource ******************/
	
	/**
	 * Check for bank branch updates
	 * @param bankCount
	 * @param branchCount
	 * @return BankList, null if no updates avalable
	 */
	@GET
	@Path("/updates")
	public Response checkForUpdates(
			@QueryParam("bankCount") int bankCount,
			@QueryParam("branchCount") int branchCount) {
		
		
		return Response.ok().build();
		
	}
}
