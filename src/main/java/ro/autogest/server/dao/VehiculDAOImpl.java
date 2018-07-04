package ro.autogest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.dao.mapper.VehiculMapper;
import ro.autogest.server.model.Vehicul;

@Repository
public class VehiculDAOImpl implements VehiculDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(Vehicul vehicul) {
		String SQL = "insert into Vehicul (id_utilizator, numar_inmatriculare, marca, model, tip, motorizare, status) values (?, ?, ?, ?, ?, ?, 'IN ASTEPTARE')";

		jdbcTemplate.update(SQL, vehicul.getIdUtilizator(), vehicul.getNumarInmatriculare(), vehicul.getMarca(), vehicul.getModelul(), vehicul.getMotorizare(), vehicul.getTip());
		System.out.println("Created Record Id_utilizator= " + vehicul.getIdUtilizator() + " Numar_inmatriculare= "
				+ vehicul.getNumarInmatriculare() + " Marca= " + vehicul.getMarca() + " Motorizare = " + vehicul.getMotorizare());
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
		String sql = "select * from Vehicul";
		List<Vehicul> vehicule = jdbcTemplate.query(sql, new VehiculMapper());
		return vehicule;
	}

	public void update(Vehicul vehicul, Integer id) {
		jdbcTemplate.update("UPDATE Vehicul SET id_vehicul = ? , numar_inmatriculare= ? , marca= ?, motorizare = ? ",
				vehicul.getId(), vehicul.getNumarInmatriculare(), vehicul.getMarca(),
				vehicul.getMotorizare());
	}

	public void delete(Integer id) {
		jdbcTemplate.update("DELETE from Vehicul WHERE id_vehicul = ? ", id);
	}

	public Vehicul getVehiculByIdSofer(Integer idSofer) {
		String sql = "SELECT * FROM Vehicul WHERE id_utilizator = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { idSofer }, new VehiculMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
