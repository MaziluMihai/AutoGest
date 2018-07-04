package ro.autogest.server.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.AsigurareDAO;
import ro.autogest.server.dao.InregistrareAlimentareDAO;
import ro.autogest.server.dao.IntrareServiceDAO;
import ro.autogest.server.dao.TaxaDAO;
import ro.autogest.server.dao.UtilizatorDAO;
import ro.autogest.server.dao.VehiculDAO;
import ro.autogest.server.exception.NotFoundException;
import ro.autogest.server.exception.ValidationException;
import ro.autogest.server.model.Asigurare;
import ro.autogest.server.model.InregistrareAlimentare;
import ro.autogest.server.model.IntrareService;
import ro.autogest.server.model.Taxa;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.model.Vehicul;

@Service
public class VehiculService {

	@Autowired
	private VehiculDAO vehiculDAO;
	
	@Autowired
	private UtilizatorDAO utilizatorDAO;

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
		verificareVehiculInService(id);
		
		Vehicul vehicul = vehiculDAO.getVehicul(id);
		if (vehicul == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit");
		}
		return vehicul;
	}


	public Vehicul getVehiculByIdSofer(int idSofer) throws NotFoundException {
		verificareVehiculInService(vehiculDAO.getVehiculByIdSofer(idSofer).getId());
		
		Vehicul vehicul = vehiculDAO.getVehiculByIdSofer(idSofer);
		if (vehicul == null) {
			throw new NotFoundException("Vehiculul nu a fost gasit pe baza id-ului de sofer");
		}
		return vehicul;
	}

	public List<Vehicul> listeazaVehicule() {
		verificareVehiculeInService();
		
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
	

	
	private void verificareVehiculInService(int id) {
		List<IntrareService> intrariService = intrareServiceDAO.findByVehiculId(id);
		Vehicul vehicul = vehiculDAO.getVehicul(id);
		
		
		for (Iterator iterator = intrariService.iterator(); iterator.hasNext();) {
			IntrareService intrareService = (IntrareService) iterator.next();
			if(intrareService.getDataIntrare().before(new Date()) && intrareService.getDataIesire().after(new Date())){
				vehiculDAO.updateStatus("INACTIVA", id);
			} else if(intrareService.getDataIesire().before(new Date()) && "INACTIVA".equals(vehicul.getStatusVehicul())) {
				if(vehicul.getIdUtilizator() == null) {
					vehiculDAO.updateStatus("IN ASTEPTARE", id);
				} else {
					vehiculDAO.updateStatus("ACTIVA", id);
				}
			}
		}
		
	}
	
	private void verificareVehiculeInService() {
		List<Vehicul> listaVehicule = vehiculDAO.listaVehicule();
		for (Iterator iterator = listaVehicule.iterator(); iterator.hasNext();) {
			Vehicul vehicul = (Vehicul) iterator.next();
			verificareVehiculInService(vehicul.getId());
		}
	}

	public void asignareSofer(int idVehicul, Utilizator utilizator) throws ValidationException {
		Utilizator dbUtilizator = utilizatorDAO.getUtilizator(utilizator.getId());
		if(dbUtilizator == null) {
			throw new ValidationException("Soferul selectat nu exista!");
		}
		Vehicul vehicul = vehiculDAO.getVehicul(idVehicul);
		if(vehicul == null) {
			throw new ValidationException("Vehiculul selectat nu exista!");
		}
		if(!vehicul.getStatusVehicul().equals("IN ASTEPTARE")) {
			throw new ValidationException("Vehiculul este inactiv sau are deja un sofer asignat!");
		}
		vehiculDAO.updateUtilizator(idVehicul, utilizator.getId());
		vehiculDAO.updateStatus("ACTIVA", idVehicul);
	}

	public void deAsignareSofer(int idVehicul)  throws ValidationException {
		Vehicul vehicul = vehiculDAO.getVehicul(idVehicul);
		if(vehicul == null) {
			throw new ValidationException("Vehiculul selectat nu exista!");
		}
		if(!vehicul.getStatusVehicul().equals("ACTIVA")) {
			throw new ValidationException("Vehiculul este inactiv sau in asteptare!");
		}
		vehiculDAO.updateUtilizator(idVehicul, null);
		vehiculDAO.updateStatus("IN ASTEPTARE", idVehicul);
	}
}
