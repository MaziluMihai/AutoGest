package ro.autogest.server.dao;

import java.util.List;

import ro.autogest.server.model.Vehicul;

public interface VehiculDAO {
	
	public void create(Integer id_utilizator, String numar_inmatriculare, String marca, String motorizare);

	public Vehicul getVehicul(Integer id);

	public Vehicul getVehiculByNumarInmatriculare(String numar_inmatriculare);

	public List<Vehicul> listaVehicule();

	public void update(Vehicul vehicul, Integer id);

	public void delete(Integer id);

}
