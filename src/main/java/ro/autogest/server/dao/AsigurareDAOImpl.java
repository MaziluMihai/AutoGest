package ro.autogest.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.model.Asigurare;

@Repository
public class AsigurareDAOImpl implements AsigurareDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Asigurare asigurare) {

		String SQL = "insert into asigurare (id_vehicul, id_utilizator, tip_asigurare, data_creare, "
				+ "data_expirare,cost_asigurare, companie_asiguratoare) values (?, ?, ?, ?,?,?, ?)";

		jdbcTemplate.update(SQL, asigurare.getIdVehicul(), asigurare.getIdUtilizator(), asigurare.getTipAsigurare(),
				asigurare.getDataCreare(), asigurare.getDataExpirare(), asigurare.getCostAsigurare(),
				asigurare.getCompaniaAsiguratoare());

	}

}
