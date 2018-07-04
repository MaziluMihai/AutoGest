package ro.autogest.server.dao;

import java.util.List;

import ro.autogest.server.model.Vehicul;

public interface VehiculDAO {
	
	public void create(Vehicul vehicul);

	public Vehicul getVehicul(Integer id);

	public Vehicul getVehiculByNumarInmatriculare(String numar_inmatriculare);
	
	public Vehicul getVehiculByIdSofer(Integer idSofer);

	public List<Vehicul> listaVehicule();

	public void update(Vehicul vehicul, Integer id);

	public void delete(Integer id);

}
