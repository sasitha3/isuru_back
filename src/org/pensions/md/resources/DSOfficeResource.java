package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.services.SuportiveDataService;

import io.swagger.annotations.Api;

@Api(
		tags = {"DS Office"},
		consumes = MediaType.APPLICATION_JSON,
		produces = MediaType.APPLICATION_JSON
	)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DSOfficeResource {
	
	@GET
	public Response getDSOffice(@PathParam("districtId") int districtId) {
		System.out.println("IN DS");
		return Response.ok(
				new SuportiveDataService().getAllDsOffice(districtId)	
				).build();
	}
	
	@Path("/{dsofficeId}/vo")
	public VillageOfficeResource goToVillageOfficeResource() {
		return new VillageOfficeResource();
	}
	
	
}
