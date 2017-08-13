package org.pensions.md.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.pensions.md.model.dto.SalaryDTO;
import org.pensions.md.services.SalaryService;
import org.pensions.md.util.DateUtil;

import io.swagger.annotations.Api;

@Api(
		tags = {"GOV Salaries"},
		consumes = MediaType.APPLICATION_JSON,
		produces = MediaType.APPLICATION_JSON
	)
@Path("/salary")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SalaryResource {

	@GET
	public Response getSalary(
			@QueryParam("scale") String scale,
			@QueryParam("grade") String grade,
			@QueryParam("circular") String circualar,
			@QueryParam("salary") double salary,
			@QueryParam("target") String target,
			@QueryParam("retired_date") String retiredDate,
			@QueryParam("increment_date") String incrementDate
			) {
		
		SalaryService service = new SalaryService();
		if(grade.equals("no-grade")) grade = "";
		
		SalaryDTO model = service.getSalaryFor(scale, grade, circualar, salary, target, DateUtil.toDate(retiredDate), DateUtil.toDate(incrementDate));
		System.out.println("Salsary 2");				
		return Response.ok(model).build();
	}
	
}
