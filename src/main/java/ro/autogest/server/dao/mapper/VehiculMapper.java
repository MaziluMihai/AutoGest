package ro.autogest.server.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.autogest.server.model.Vehicul;

public class VehiculMapper implements RowMapper<Vehicul> {

	public Vehicul mapRow(ResultSet rs, int row) throws SQLException {
		Vehicul v = new Vehicul();
		v.setId(rs.getInt("id_vehicul"));
		v.setId_utilizator(rs.getInt("id_utilizator"));
		v.setNumar_inmatriculare(rs.getString("numar_inmatriculare"));
		v.setMarca(rs.getString("marca"));
		v.setMotorizare(rs.getString("motorizare"));

		return v;

	}
}
