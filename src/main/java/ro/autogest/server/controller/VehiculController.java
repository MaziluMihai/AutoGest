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
import ro.autogest.server.model.Asigurare;
import ro.autogest.server.model.BooleanResponse;
import ro.autogest.server.model.InregistrareAlimentare;
<<<<<<< HEAD
import ro.autogest.server.model.Utilizator;
=======
import ro.autogest.server.model.IntrareService;
import ro.autogest.server.model.Taxa;
>>>>>>> 7011055ba602b5b2842c0b01ff6f454f9700fe20
import ro.autogest.server.model.Vehicul;
import ro.autogest.server.service.UtilizatorService;
import ro.autogest.server.service.VehiculService;

@Path("/vehicul")
public class VehiculController {

	@Autowired
	private VehiculService vehiculService;

<<<<<<< HEAD
	@Autowired
	private UtilizatorService utilizatorService;
   
=======
>>>>>>> 7011055ba602b5b2842c0b01ff6f454f9700fe20
	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Vehicul getVehicul(@PathParam("id") int id) throws NotFoundException {

		return vehiculService.getVehiculById(id);
	}
<<<<<<< HEAD
	
	@GET
	@Path("/sofer/{emailSofer}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Vehicul getVehiculByEmailSofer(@PathParam("emailSofer") String emailSofer) throws NotFoundException {

		Utilizator sofer = utilizatorService.getUserByEmail(emailSofer);
		if(sofer == null) {
			throw new NotFoundException("Soferul nu a fost gasit!");
		}
		
		return vehiculService.getVehiculByIdSofer(sofer.getId());
	}
	
=======

>>>>>>> 7011055ba602b5b2842c0b01ff6f454f9700fe20
	@POST
	@Path("/create")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response createVehicul(Vehicul vehicul) throws ValidationException {
<<<<<<< HEAD
		vehiculService.creareVehicul(vehicul);
=======
		vehiculService.creareVehicul(vehicul.getId_utilizator(), vehicul.getNumar_inmatriculare(), vehicul.getMarca(),
				vehicul.getMotorizare());
>>>>>>> 7011055ba602b5b2842c0b01ff6f454f9700fe20
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}

	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Vehicul> getVehicule() {
		return vehiculService.listeazaVehicule();
	}

	@PUT
	@Path("/{id}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response updateVehicul(Vehicul vehicul, @PathParam("id") int id) throws NotFoundException {
		vehiculService.editareVehicul(vehicul, id);
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response stergereVehicul(@PathParam("id") int id) throws NotFoundException {
		vehiculService.stergereVehicul(id);
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}

	@POST
	@Path("/inregistrare")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public BooleanResponse creareInregistrare(InregistrareAlimentare inregistrare) throws ValidationException {
		return new BooleanResponse(vehiculService.creareAlimentare(inregistrare));
	}

	@POST
	@Path("/intrareService")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public BooleanResponse creareIntrareService(IntrareService intrareService) throws ValidationException {
		return new BooleanResponse(vehiculService.creareIntrareService(intrareService));
	}
	
	@POST
	@Path("/creareAsigurare")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public BooleanResponse creareAsigurare(Asigurare asigurare) throws ValidationException {
		return new BooleanResponse(vehiculService.creareAsigurare(asigurare));
	}
	
	@POST
	@Path("/creareTaxa")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public BooleanResponse creareTaxa(Taxa taxa) throws ValidationException {
		return new BooleanResponse(vehiculService.creareTaxa(taxa));
	}
}
