package ro.autogest.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.model.InregistrareAlimentare;

@Repository
public class InregistrarelimentareDAOImpl implements InregistrareAlimentareDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void create(InregistrareAlimentare inregistrareAlimentare) {
		String SQL = "insert into inregistrare_alimentare (tip_carburant, pret_litru, cantitate, numar_km, id_vehicul,id_card_benzina, id_benzinarie) values (?, ?, ?, ?,?,?, ?)";

		jdbcTemplate.update(SQL, inregistrareAlimentare.getTipCarburant(), inregistrareAlimentare.getPret(), inregistrareAlimentare.getCantitate(), inregistrareAlimentare.getKm(), inregistrareAlimentare.getIdVehicul(), inregistrareAlimentare.getIdCard(), inregistrareAlimentare.getIdBenzinarie());
		return;
	}

	
}
