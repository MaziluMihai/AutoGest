package ro.autogest.server.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.autogest.server.model.Benzinarie;

public class BenzinarieMapper implements RowMapper<Benzinarie>{

	public Benzinarie mapRow(ResultSet rs, int row) throws SQLException {
		Benzinarie b =new Benzinarie();
		b.setId(rs.getInt("id_benzinarie"));
		b.setEmail(rs.getString("email"));
		b.setDenumire(rs.getString("denumire"));
		b.setTelefon(rs.getString("telefon"));
		b.setLocatie(rs.getString("locatie"));
		return b;
		
	}

}
