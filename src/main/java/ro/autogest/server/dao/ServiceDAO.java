package ro.autogest.server.dao;

import java.util.List;


import ro.autogest.server.model.Service;

public interface ServiceDAO {

	public void create(String denumire, String locatie, String telefon, String email);

	public Service getService(Integer id);

	public List<Service> listaServiceuri();
}
