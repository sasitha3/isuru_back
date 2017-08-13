package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.model.dto.DistrictDTO;
import org.pensions.md.model.pojo.VillageOffice;
import org.pensions.md.services.SuportiveDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(
		tags = {"Supportive Data"},
		consumes = MediaType.APPLICATION_JSON,
		produces = MediaType.APPLICATION_JSON
	)
@Path("/supportive")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SupportiveResource {

	/**
	 * get pensioner office details
	 * @return
	 */
	@ApiOperation(value = "get village office and other office data",
			notes = "Get all districts",
			response = DistrictDTO.class, 
			responseContainer = "List",
			code = 200
			)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "no Village office found")
	})
	@GET
	@Path("/vo/{officeId}")
	public Response getVilleageOfficeDetails(@PathParam("officeId") long officeId) {
		VillageOffice villageOfficeDetails = new SuportiveDataService().getVillageOfficeDetails(officeId);
		
		return Response.ok(villageOfficeDetails).build();
	}
	
	@Path("/districts")
	public DistrictResource goToDistrictResource() {
		return new DistrictResource();
	}
	
		
}
