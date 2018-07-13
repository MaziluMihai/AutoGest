package ro.autogest.server.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.model.Benzinarie;
import ro.autogest.server.model.BenzinarieListResponse;
import ro.autogest.server.model.ServerResponse;

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
	
	
	@POST
	@Path("/create")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse createBenzinarie(Benzinarie benzinarie) {
	
			benzinarieService.creareBenzinarie(benzinarie);
			return new ServerResponse("Benzinarie adaugata cu succes!", true);
	
	}
	
	@PUT
	@Path("/update")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse updateBenzinarie(Benzinarie benzinarie) {
	
			benzinarieService.updateBenzinarie(benzinarie);
			return new ServerResponse("Benzinarie modificata cu succes!", true);
	
	}
	
	@DELETE
	@Path("/{id}")
	@Transactional
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse stergereBenzinarie(@PathParam("id") int id) throws NotFoundException {
		benzinarieService.deleteBenzinarie(id);
		return new ServerResponse("Benzinaria a fost stearsa cu succes",true);
	}
	
	
	
}
