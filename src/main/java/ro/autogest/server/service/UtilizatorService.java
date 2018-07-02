package ro.autogest.server.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.UtilizatorDAO;
import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.Utilizator;

@Service
public class UtilizatorService {

	Logger LOGGER = Logger.getLogger(UtilizatorService.class);
	
	@Autowired
	private UtilizatorDAO utilizatorDAO;

	public Utilizator creareUtilizator(String nume, String prenume, String tip_utilizator, String email,
			String parola, String functia, Integer telefon) throws ValidationException {
		
		if (utilizatorDAO.getUtilizatorByEmail(email) != null) {
			throw new ValidationException("Utilizatorul cu emailul " + email + " exista deja!");
		}

		utilizatorDAO.create(nume, prenume, tip_utilizator, email, parola, functia, telefon);
		return utilizatorDAO.getUtilizatorByEmail(email);
	}

	public Utilizator getUserById(int id) throws NotFoundException {
		Utilizator utilizator = utilizatorDAO.getUtilizator(id);
		if (utilizator == null) {
			throw new NotFoundException("Utilizatorul nu a fost gasit");
		}
		return utilizator;
	}

	public List<Utilizator> listeazaUtilizatori() {
		return utilizatorDAO.listaUtilizatori();
	}

	public void editareUtilizator(Utilizator utilizator, int id) throws NotFoundException {
		Utilizator dbUtilizator = utilizatorDAO.getUtilizator(id);
		if (dbUtilizator == null) {
			throw new NotFoundException("Utilizatorul nu a fost gasit");
		}

		if (utilizator.getEmail() == null) {
			utilizator.setEmail(dbUtilizator.getEmail());
		}

		utilizatorDAO.update(utilizator, id);
	}

	public void stergereUtilizator(int id) throws NotFoundException {
		Utilizator dbUtilizator = utilizatorDAO.getUtilizator(id);
		if (dbUtilizator == null) {
			throw new NotFoundException("Utilizatorul nu a fost gasit");
		}
		utilizatorDAO.delete(id);
	}

	public Utilizator getUserByEmail(String email) {

		return utilizatorDAO.getUtilizatorByEmail(email);
	}

	public Boolean existaUser(String email) {
		if (utilizatorDAO.getUtilizatorByEmail(email) != null)
			return true;
		else
			return false;
	}


}
