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

import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.BooleanResponse;
import ro.autogest.server.model.CredentialeLogin;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.service.UtilizatorService;

@Path("/user")
public class UtilizatorController {

	@Autowired
	private UtilizatorService utilizatorService;

	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Utilizator getUtilizator(@PathParam("id") int id) throws NotFoundException {

		return utilizatorService.getUserById(id);
	}

	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Utilizator> getUtilizatori() {
		return utilizatorService.listeazaUtilizatori();
	}

	@POST
	@Path("/create")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response createUtilizator(Utilizator utilizator) throws ValidationException {
		utilizatorService.creareUtilizator(utilizator.getNume(), utilizator.getPrenume(), utilizator.getEmail(),
				utilizator.getParola(), utilizator.getFunctia());
		return Response.status(Response.Status.OK.getStatusCode()).build();
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

	@POST
	@Path("/login")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public BooleanResponse login(CredentialeLogin credentialeLogin) throws ValidationException {
		if (utilizatorService.existaUser(credentialeLogin.getEmail()))
			return new BooleanResponse(true);
		else
			return new BooleanResponse(false);
	}
	
	

}
