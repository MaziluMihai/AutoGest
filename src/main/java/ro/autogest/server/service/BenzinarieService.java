package ro.autogest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.BenzinarieDAO;

import ro.autogest.server.model.Benzinarie;

@Service
public class BenzinarieService {

	@Autowired
	BenzinarieDAO benzinarieDAO;

	public List<Benzinarie> listeazaBenzinarii() {
		return benzinarieDAO.listaBenzinarii();
	}

	public Benzinarie creareBenzinarie(Benzinarie benzinarie) {

		benzinarieDAO.create(benzinarie.getDenumire(), benzinarie.getLocatie(), benzinarie.getTelefon(),
				benzinarie.getEmail());
		return benzinarieDAO.getBenzinarie(benzinarie.getId());
	}

	public void updateBenzinarie(Benzinarie benzinarie) {
		benzinarieDAO.update(benzinarie.getId(), benzinarie.getDenumire(), benzinarie.getLocatie(),
				benzinarie.getTelefon(), benzinarie.getEmail());

	}
	
	public void deleteBenzinarie(Integer id) {
		benzinarieDAO.delete(id);
		
	}
}
