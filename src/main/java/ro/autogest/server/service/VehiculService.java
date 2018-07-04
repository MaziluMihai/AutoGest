package ro.autogest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.AsigurareDAO;
import ro.autogest.server.dao.InregistrareAlimentareDAO;
import ro.autogest.server.dao.IntrareServiceDAO;
import ro.autogest.server.dao.TaxaDAO;
import ro.autogest.server.dao.VehiculDAO;
import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.Asigurare;
import ro.autogest.server.model.InregistrareAlimentare;
import ro.autogest.server.model.IntrareService;
import ro.autogest.server.model.Taxa;
import ro.autogest.server.model.Vehicul;

@Service
public class VehiculService {

	@Autowired
	private VehiculDAO vehiculDAO;

	@Autowired
	private InregistrareAlimentareDAO inregistrareDAO;

	@Autowired
	private IntrareServiceDAO intrareServiceDAO;
	
	@Autowired
	private AsigurareDAO asigurareDAO;
	
	@Autowired
	private TaxaDAO taxaDAO;

	public Vehicul creareVehicul(Vehicul vehicul) throws ValidationException {
		// validate unique id_utilizator
		if (vehiculDAO.getVehiculByNumarInmatriculare(vehicul.getNumarInmatriculare()) != null) {
			throw new ValidationException("Vehiculul cu numarul " + vehicul.getNumarInmatriculare() + " exista deja!");
		}

		vehiculDAO.create(vehicul);
		return vehiculDAO.getVehiculByNumarInmatriculare(vehicul.getNumarInmatriculare());
	}

	public Vehicul getVehiculById(int id) throws NotFoundException {
		Vehicul vehicul = vehiculDAO.getVehicul(id);
		if (vehicul == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit");
		}
		return vehicul;
	}
	
	public Vehicul getVehiculByIdSofer(int idSofer) throws NotFoundException {
		Vehicul vehicul = vehiculDAO.getVehiculByIdSofer(idSofer);
		if (vehicul == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit pe baza id-ului de sofer");
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
		if (vehicul.getNumarInmatriculare() == null) {
			vehicul.setNumarInmatriculare(vehicul2.getNumarInmatriculare());
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
		// TODO:
		// validare numar de km, daca id-ul vehicului corespunde utriliztorului care
		// face cererea, etc..
		inregistrareDAO.create(inregistrare);
		return true;
	}

	public boolean creareIntrareService(IntrareService intrareService) {
		intrareServiceDAO.create(intrareService);
		return true;
	}
	
	public boolean creareAsigurare(Asigurare asigurare) {
		asigurareDAO.create(asigurare);
		return true;
	}
	
	public boolean creareTaxa(Taxa taxa) {
		taxaDAO.create(taxa);
		return true;
	}
}
