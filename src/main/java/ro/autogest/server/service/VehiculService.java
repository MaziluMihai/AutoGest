package ro.autogest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.InregistrareAlimentareDAO;
import ro.autogest.server.dao.VehiculDAO;
import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.InregistrareAlimentare;
import ro.autogest.server.model.Vehicul;

@Service
public class VehiculService {

	@Autowired
	private VehiculDAO vehiculDAO;

	@Autowired
	private InregistrareAlimentareDAO inregistrareDAO;

	public Vehicul creareVehicul(Integer id_utilizator, String numar_inmatriculare, String marca, String motorizare) throws ValidationException {
		// validate unique id_utilizator
		if (vehiculDAO.getVehiculByNumarInmatriculare(numar_inmatriculare) != null) {
			throw new ValidationException("Vehiculul cu numarul " + numar_inmatriculare + " exista deja!");
		}

		vehiculDAO.create(id_utilizator, numar_inmatriculare, marca, motorizare);
		return vehiculDAO.getVehiculByNumarInmatriculare(numar_inmatriculare);
	}

	public Vehicul getVehiculById(int id) throws NotFoundException {
		Vehicul vehicul = vehiculDAO.getVehicul(id);
		if (vehicul == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit");
		}
		return vehicul;
	}

	public List<Vehicul> listeazaVehicule() {
		return vehiculDAO.listaVehicule();
	}

	public void editareVehicul(Vehicul vehicul, int id) throws NotFoundException {
		Vehicul vehicul2 = vehiculDAO.getVehicul(id);
		if (vehicul2 == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit");
		}
		if (vehicul.getNumar_inmatriculare() == null) {
			vehicul.setNumar_inmatriculare(vehicul2.getNumar_inmatriculare());
		}

		vehiculDAO.update(vehicul, id);
	}

	public void stergereVehicul(int id) throws NotFoundException {
		Vehicul vehicul = vehiculDAO.getVehicul(id);
		if (vehicul == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit");
		}
		vehiculDAO.delete(id);
	}


	public boolean creareAlimentare(InregistrareAlimentare inregistrare) {
		//TODO:
		//validare numar de km, daca id-ul vehicului corespunde utriliztorului care face cererea, etc..
		inregistrareDAO.create(inregistrare);
		return true;
	}
}
