package ro.autogest.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.autogest.server.model.Utilizator;

public class UtilizatorMapper implements RowMapper<Utilizator>{

	public Utilizator mapRow(ResultSet rs, int row) throws SQLException {
		Utilizator u =new Utilizator();
		u.setId(rs.getInt("id_utilizator"));
		u.setEmail(rs.getString("email"));
		u.setNume(rs.getString("nume"));
		return u;
		
	}

}
