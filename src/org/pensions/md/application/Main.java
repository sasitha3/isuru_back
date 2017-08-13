package org.pensions.md.application;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.pensions.md.exceptions.mappers.DataNotFoundExceptionMapper;
import org.pensions.md.exceptions.mappers.ThrowableExceptionMapper;
import org.pensions.md.exceptions.mappers.UnAuthorizedExceptionMapper;
import org.pensions.md.exceptions.mappers.UserNotFoundExceptionMapper;
import org.pensions.md.filters.CorsFilter;
import org.pensions.md.resources.BankResource;
import org.pensions.md.resources.BranchResource;
import org.pensions.md.resources.PercentageResource;
import org.pensions.md.resources.SalaryResource;
import org.pensions.md.resources.SupportiveResource;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("api")
public class Main extends Application {
	Logger LOGGER = Logger.getLogger(Main.class.getName());

	public Main() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("PENSIONS MASTER DATA API");
		beanConfig.setVersion("1.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080/pms_masterdata_api");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("org.pensions.md.resources");
		beanConfig.setScan(true);
		
	}

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> resources = new HashSet<Class<?>>();

		/******* resource mappings *********/
		resources.add(BankResource.class);
		resources.add(BranchResource.class);
		resources.add(PercentageResource.class);
		resources.add(SalaryResource.class);
		resources.add(SupportiveResource.class);
//		resources.add(VillageOfficeResource.class);
		
		/***** filter mappings ******/
		resources.add(CorsFilter.class);
		
		/*
		 * exception mappers
		 */
		resources.add(ThrowableExceptionMapper.class);
		resources.add(DataNotFoundExceptionMapper.class);
		resources.add(UnAuthorizedExceptionMapper.class);
		resources.add(UserNotFoundExceptionMapper.class);
		

		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;
	}

}
