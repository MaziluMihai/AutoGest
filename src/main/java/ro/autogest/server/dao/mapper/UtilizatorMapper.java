package ro.autogest.server.dao.mapper;

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
		u.setPrenume(rs.getString("prenume"));
		u.setParola(rs.getString("parola"));
		u.setFunctia(rs.getString("functia"));
		u.setTip_utilizator(rs.getString("tip_utilizator"));
		u.setTelefon(rs.getInt("telefon"));
		u.setToken(rs.getInt("token"));
		u.setTokenDate(rs.getDate("token_data_expirare"));
		return u;
		
	}

}
