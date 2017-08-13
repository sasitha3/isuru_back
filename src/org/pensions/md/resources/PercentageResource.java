package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.pensions.md.model.dto.Message;
import org.pensions.md.model.pojo.Percentage;
import org.pensions.md.services.PercentageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
		tags = {"Pension Percentages"},
		consumes = MediaType.APPLICATION_JSON,
		produces = MediaType.APPLICATION_JSON
	)
@Path("/percentages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PercentageResource {

	/*
	 * get All percentage
	 */
	@ApiOperation(value = "Get percentage details",
			notes = "Get percentage details by sending the required information",
			response = Message.class,
			code = 200
			)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Pension state update failed")
	})
	@GET
	public Response getPercentage(
			@QueryParam("type") String type,
			@QueryParam("offeredto") String offer,
			@QueryParam("years") int years,
 			@QueryParam("months") int months,
 			@QueryParam("circular") String circular,
			@QueryParam("salary") double salary) {
		
		PercentageService service = new PercentageService();
		Percentage percentage = null;
		
		//validate the number of years that a pensioner can have
		if((type.equals("milcom") || type.equals("civil")) && years < 10) {
			
			return Response
					.status(Status.NOT_FOUND)
					.entity(new Message(Status.NOT_FOUND.getStatusCode(), "a civil pensioner should have a service period of 10 years at least"))
					.build();
		} else if(type.equals("milnoncom") && years < 12) {
			
			return Response
					.status(Status.NOT_FOUND)
					.entity(new Message(Status.NOT_FOUND.getStatusCode(), "a militory non commisioned pensioner should have a service period of 12 years at least"))
					.build();
		}
			
		if(type.equals("civil")) {
			
			if(years < 25) months = 0;
			if(years >= 30) {
				years = 30;
				months = 0;
			}
			
			percentage = service.getPercentage(years <= 25 && type.equals("civil") ? 25 : years, months < 6 ? 0 : 6, salary, circular);
		
		} else if(type.equals("milcom")) {
			if(offer.equals("disabled") || offer.equals("regular"))
			percentage = service.getPercentage(years, offer, "com", circular);
		} else if(type.equals("milnoncom")) {
			if(offer.equals("disabled") || offer.equals("regular"))
			percentage = service.getPercentage(years, offer, "uncom", circular);
		} else if(type.equals("judge")) {
			percentage = service.getPercentageForJudge(years, months, salary, circular);
		}
		
		percentage.setId(null);
		percentage.setMonths(null);
		percentage.setOfferedTo(null);
		percentage.setPost(null);
		percentage.setType(null);
		percentage.setUpperLimit(null);
		percentage.setYears(null);
		percentage.setLowerLimit(null);
		

		return Response.ok(percentage).build();
	}
}
