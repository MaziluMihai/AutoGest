package ro.autogest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.autogest.server.dao.ServiceDAO;

@Service
public class ServiceService {

	@Autowired
	ServiceDAO serviceDAO;
	
	public List<ro.autogest.server.model.Service> listaServiceuri(){
		return serviceDAO.listaServiceuri();
	}
	

}
