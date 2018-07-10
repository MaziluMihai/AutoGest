package ro.autogest.server.controller;

import java.util.List;

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

import ro.autogest.server.exception.NotAuthorizedException;
import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.CredentialeLogin;
import ro.autogest.server.model.IntegerResponse;
import ro.autogest.server.model.ServerResponse;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.model.UtilizatorListResponse;
import ro.autogest.server.model.Vehicul;
import ro.autogest.server.service.SecurityService;
import ro.autogest.server.service.UtilizatorService;
import ro.autogest.server.service.VehiculService;

@Path("/user")
public class UtilizatorController {

	@Autowired
	private UtilizatorService utilizatorService;
	
	@Autowired
	private VehiculService vehiculService;

	@Autowired
	private SecurityService securityService;
	
	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilizator getUtilizator(@PathParam("id") int id) throws NotFoundException {

		return utilizatorService.getUserById(id);
	}

	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UtilizatorListResponse getUtilizatori() {
		return new UtilizatorListResponse(utilizatorService.listeazaUtilizatori());
	}

	@POST
	@Path("/create")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse createUtilizator(Utilizator utilizator) throws ValidationException {
		try {
			utilizatorService.creareUtilizator(utilizator.getNume(), utilizator.getPrenume(),utilizator.getTip_utilizator(),
					utilizator.getEmail(),utilizator.getParola(), utilizator.getFunctia(),utilizator.getTelefon());
			return new ServerResponse("Utilizator adaugat cu succes!", true);
		} catch (ValidationException e) {
			return new ServerResponse(e.getMessage(), false);
		}
		
	}

	@PUT
	@Path("/{id}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response updateUtilizator(Utilizator utilizator, @PathParam("id") int id) throws NotFoundException {
		utilizatorService.editareUtilizator(utilizator, id);
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response stergereUtilizartor(@PathParam("id") int id) throws NotFoundException {
		utilizatorService.stergereUtilizator(id);
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}

	@GET
	@Path("/email/{email}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilizator getUtilizatorByEmail(@PathParam("email") String email) throws NotFoundException {

		return utilizatorService.getUserByEmail(email);
	}
	
	@GET
	@Path("/vehicul/{idVehicul}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilizator getDriverByVehicleId(@PathParam("idVehicul") Integer idVehicul) throws NotFoundException {
		Vehicul vehicul = vehiculService.getVehiculById(idVehicul);
	
		if(vehicul == null || vehicul.getIdUtilizator() == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit sau nu are sofer asignat!");
		}
		
		return utilizatorService.getUserById(vehicul.getIdUtilizator());
	}

	@POST
	@Path("/login")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public IntegerResponse login(CredentialeLogin credentialeLogin) throws NotAuthorizedException {
		
		Integer token = securityService.login(credentialeLogin);
		return new IntegerResponse(token);
		
	}
	
	@GET
	@Path("/available-drivers")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UtilizatorListResponse getAvailableDrivers() throws NotFoundException {

		return new UtilizatorListResponse(utilizatorService.getAvailableDrivers());
	}

}
