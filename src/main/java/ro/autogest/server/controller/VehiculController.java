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
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.Asigurare;
import ro.autogest.server.model.InregistrareAlimentare;
import ro.autogest.server.model.IntrareService;
import ro.autogest.server.model.ServerResponse;
import ro.autogest.server.model.Taxa;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.model.Vehicul;
import ro.autogest.server.model.VehiculListResponse;
import ro.autogest.server.service.UtilizatorService;
import ro.autogest.server.service.VehiculService;

@Path("/vehicul")
public class VehiculController {
	
	
	@Autowired
	private VehiculService vehiculService;

	@Autowired
	private UtilizatorService utilizatorService;
   
	@GET
	@Path("/{id}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Vehicul getVehicul(@PathParam("id") int id) throws NotFoundException {

		return vehiculService.getVehiculById(id);
	}
	
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
	

	@POST
	@Path("/create")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse createVehicul(Vehicul vehicul) {
		try {
			vehiculService.creareVehicul(vehicul);
			return new ServerResponse("Vehicul adaugat cu succes!", true);
		} catch (ValidationException e) {
			return new ServerResponse(e.getMessage(), false);
		}
	}

	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public VehiculListResponse getVehicule() {
		return new VehiculListResponse(vehiculService.listeazaVehicule());
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
	public ServerResponse creareInregistrare(InregistrareAlimentare inregistrare) throws ValidationException {
		vehiculService.creareAlimentare(inregistrare);
		
		return new ServerResponse("Inregistrare adaugare cu succes", true);
	}

	@POST
	@Path("/intrareService")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse creareIntrareService(IntrareService intrareService) throws ValidationException {
		vehiculService.creareIntrareService(intrareService);
		return new ServerResponse("Inregistrare adaugare cu succes", true);
	}
	
	@POST
	@Path("/creareAsigurare")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse creareAsigurare(Asigurare asigurare) throws ValidationException {
		vehiculService.creareAsigurare(asigurare);
		return new ServerResponse("Asigurare adaugata cu succes", true);
	}
	
	@POST
	@Path("/creareTaxa")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse creareTaxa(Taxa taxa) throws ValidationException {
		vehiculService.creareTaxa(taxa);
		return new ServerResponse("Taxa adaugata cu succes", true);
	}
	

	@PUT
	@Path("/assign-driver/{idVehicul}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse asignareSofer(Utilizator utilizator, @PathParam("idVehicul") int idVehicul) throws NotFoundException {
		try {
			vehiculService.asignareSofer(idVehicul, utilizator);
		} catch (ValidationException e) {
			return new ServerResponse(e.getMessage(), false);
		}
		return new ServerResponse("Soferul a fost asignat cu succces!", true);
	}
	
	@PUT
	@Path("/unassign-driver")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_JSON })
	public ServerResponse deAsignareSofer(Vehicul vehicul) throws NotFoundException {
		try {
			vehiculService.deAsignareSofer(vehicul.getId());
		} catch (ValidationException e) {
			return new ServerResponse(e.getMessage(), false);
		}
		return new ServerResponse("Soferul a fost dezasociat cu succces!", true);
	}
}
