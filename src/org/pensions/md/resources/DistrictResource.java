package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.model.dto.DistrictDTO;
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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DistrictResource {

	/**
	 * get all districts
	 * @return
	 */
	@ApiOperation(value = "Get all districts",
			notes = "Get all districts",
			response = DistrictDTO.class, 
			responseContainer = "List",
			code = 200
			)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "no banks found")
	})
	@GET
	public Response getDistrict() {
				
		return Response.ok(
				new SuportiveDataService().getAllDistricts()
				).build();
	}
	
	@Path("/{districtId}/dsoffice")
	public DSOfficeResource goToDSOfficeResource() {
		return new DSOfficeResource();
	}
	
		
}
