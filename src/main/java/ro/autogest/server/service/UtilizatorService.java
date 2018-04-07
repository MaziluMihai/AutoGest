package ro.autogest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.UtilizatorDAO;
import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.Utilizator;

@Service
public class UtilizatorService {

	@Autowired
	private UtilizatorDAO utilizatorDAO;

	public Utilizator creareUtilizator(String nume, String email) throws ValidationException {
		// validate unique email
		if (utilizatorDAO.getUtilizatorByEmail(email) != null) {
			throw new ValidationException("Utilizatorul cu emailul " + email + " exista deja!");
		}

		utilizatorDAO.create(nume, email);
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

}
