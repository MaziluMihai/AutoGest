package ro.autogest.server.dao;

import java.util.List;

import ro.autogest.server.model.IntrareService;

public interface IntrareServiceDAO {

	public void create(IntrareService intrareService);
	
	public List<IntrareService> findByVehiculId(int idVehicul);
}
