package ro.autogest.server.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.autogest.server.model.Service;

public class ServiceMapper implements RowMapper<Service> {

	public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
		Service s = new Service();
		s.setDenumire(rs.getString("denumire"));
		s.setEmail(rs.getString("email"));
		s.setLocatie(rs.getString("locatie"));
		s.setTelefon(rs.getString("telefon"));
		return s;
	}

}
