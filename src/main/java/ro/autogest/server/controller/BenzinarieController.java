package ro.autogest.server.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import ro.autogest.server.model.BenzinarieListResponse;
import ro.autogest.server.service.BenzinarieService;

@Path("/gas-station")
public class BenzinarieController {

	@Autowired
	BenzinarieService benzinarieService;
	
	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BenzinarieListResponse getUtilizatori() {
		return new BenzinarieListResponse(benzinarieService.listeazaBenzinarii());
	}
}
