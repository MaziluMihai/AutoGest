package ro.autogest.server.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import ro.autogest.server.model.ServiceListRsponse;
import ro.autogest.server.service.ServiceService;

@Path("/service")
public class ServiceController {
      
	@Autowired
	ServiceService service;
	
	@GET
	@Path("/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ServiceListRsponse getServiceuri() {
		return new ServiceListRsponse(service.listaServiceuri());
	}
	
}
