package ro.autogest.server.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.autogest.server.model.Vehicul;

public class VehiculMapper implements RowMapper<Vehicul> {

	public Vehicul mapRow(ResultSet rs, int row) throws SQLException {
		Vehicul v = new Vehicul();
		v.setId(rs.getInt("id_vehicul"));
		v.setIdUtilizator(rs.getInt("id_utilizator"));
		v.setStatusVehicul(rs.getString("status_vehicul"));
		v.setNumarInmatriculare(rs.getString("numar_inmatriculare"));
		v.setMarca(rs.getString("marca"));
		v.setModelul(rs.getString("modelul"));
		v.setTip(rs.getString("tip"));
		v.setMotorizare(rs.getString("motorizare"));
		v.setAnFabricatie(rs.getInt("an_fabricatiei"));
		v.setConsum(rs.getInt("consumul_normal"));

		return v;

	}
}
