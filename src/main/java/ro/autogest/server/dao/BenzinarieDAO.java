package ro.autogest.server.dao;

import java.util.List;

import ro.autogest.server.model.Benzinarie;
import ro.autogest.server.model.Utilizator;

public interface BenzinarieDAO {

	public void create(String denumire, String locatie, String telefon, String email);

	public Benzinarie getBenzinarie(Integer id);
	
	public Benzinarie getBenzinarieByEmail(String email);

	public List<Benzinarie> listaBenzinarii();

	public void update(Integer id, String denumire, String locatie, String telefon, String email);

	public void delete(Integer id);
}
