package ro.autogest.server.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.service.UtilizatorService;


@Path("/user")
public class UserController {
	
	@Autowired
	private UtilizatorService utilizatorService;

	@GET
	@Path("/user-info/{id}")
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Utilizator getUtilizator(@PathParam("id") int id) throws NotFoundException{
		
		return  utilizatorService.getUserById(id);
	}
	@GET
	@Path("/list")
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Utilizator> getUtilizatori(){
		return  utilizatorService.listeazaUtilizatori();
	}

	@POST
	@Path("/create")
	@Transactional
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(value={MediaType.APPLICATION_JSON})
	public Utilizator createUtilizator(Utilizator utilizator) throws ValidationException {
		return utilizatorService.creareUtilizator(utilizator.getNume(), utilizator.getEmail());
	}
	
	
}
