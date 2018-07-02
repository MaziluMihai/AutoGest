package ro.autogest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.dao.mapper.UtilizatorMapper;
import ro.autogest.server.dao.mapper.VehiculMapper;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.model.Vehicul;

@Repository
public class VehiculDAOImpl implements VehiculDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Integer id_utilizator, String numar_inmatriculare, String marca, String motorizare) {
		String SQL = "insert into Vehicul (id_utilizator, numar_inmatriculare, marca, motorizare) values (?, ?, ?, ?)";

		jdbcTemplate.update(SQL, id_utilizator, numar_inmatriculare, marca, motorizare);
		System.out.println("Created Record Id_utilizator= " + id_utilizator + " Numar_inmatriculare= "
				+ numar_inmatriculare + " Marca= " + marca + " Motorizare = " + motorizare);
		return;
	}

	public Vehicul getVehicul(Integer id) {
		String sql = "SELECT * FROM Vehicul WHERE id_vehicul = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new VehiculMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Vehicul getVehiculByNumarInmatriculare(String numar_inmatriculare) {
		String sql = "SELECT * FROM Vehicul WHERE numar_inmatriculare = ?";

		List<Vehicul> vehicule = jdbcTemplate.query(sql, new Object[] { numar_inmatriculare }, new VehiculMapper());

		if (vehicule == null || (vehicule != null && vehicule.size() == 0)) {
			return null;
		}
		return vehicule.get(0);
	}

	public List<Vehicul> listaVehicule() {
		String sql = "select * from Vehiculr";
		List<Vehicul> vehicule = jdbcTemplate.query(sql, new VehiculMapper());
		return vehicule;
	}

	public void update(Vehicul vehicul, Integer id) {
		jdbcTemplate.update("UPDATE Vehicul SET id_vehicul = ? , numar_inmatriculare= ? , marca= ?, motorizare = ? ",
				vehicul.getId_utilizator(), vehicul.getNumar_inmatriculare(), vehicul.getMarca(),
				vehicul.getMotorizare());
	}

	public void delete(Integer id) {
		jdbcTemplate.update("DELETE from Vehicul WHERE id_vehicul = ? ", id);
	}
}
