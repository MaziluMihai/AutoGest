package ro.autogest.server.dao;

import java.util.List;

import ro.autogest.server.model.Utilizator;

public interface UtilizatorDAO {

	public void create(String nume, String prenume, String tip_utilizator, String email, 
			String parola, String functie, Integer telefon);

	public void update(Utilizator utilizator, Integer id);

	public void delete(Integer id);

	public Utilizator getUtilizator(Integer id);

	public Utilizator getUtilizatorByEmail(String email);

	public List<Utilizator> listaUtilizatori();

	public List<Utilizator> getAvailableDrivers();

}
