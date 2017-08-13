package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.model.pojo.VillageOffice;
import org.pensions.md.services.SuportiveDataService;

import io.swagger.annotations.Api;

@Api(
	tags = {"VillageOffice"},
	consumes = MediaType.APPLICATION_JSON,
	produces = MediaType.APPLICATION_JSON
	)

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VillageOfficeResource {
	
	
	@GET
	public Response getDistrict(@PathParam("dsofficeId") int dsofficeId) {
		
		return Response.ok(
				new SuportiveDataService().getAllVillageOffice(dsofficeId)
				).build();
	}
	
	@GET
	@Path("/{officeId}")
	public Response getVilleageOfficeDetails(@PathParam("officeId") long officeId) {
		VillageOffice villageOfficeDetails = new SuportiveDataService().getVillageOfficeDetails(officeId);
		
		return Response.ok(villageOfficeDetails).build();
	}
}
