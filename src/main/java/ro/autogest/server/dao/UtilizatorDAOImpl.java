package ro.autogest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.dao.mapper.UtilizatorMapper;
import ro.autogest.server.model.Utilizator;

@Repository
public class UtilizatorDAOImpl implements UtilizatorDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(String nume, String email) {
		String SQL = "insert into Utilizator (nume, email) values (?, ?)";

		jdbcTemplate.update(SQL, nume, email);
		System.out.println("Created Record Name = " + nume + " Age = " + email);
		return;
	}

	public Utilizator getUtilizator(Integer id) {
		String sql = "SELECT * FROM Utilizator WHERE id_utilizator = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {id}, new UtilizatorMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Utilizator getUtilizatorByEmail(String email) {
		String sql = "SELECT * FROM Utilizator WHERE email = ?";

		List<Utilizator> utilizatori = jdbcTemplate.query(sql, new Object[] {email}, new UtilizatorMapper());
		
		if(utilizatori == null || (utilizatori != null && utilizatori.size() == 0)){
			return null;
		}
		return utilizatori.get(0);
	}

	public List<Utilizator> listaUtilizatori() {
		String sql = "select * from Utilizator";
		List<Utilizator> utilizatori = jdbcTemplate.query(sql, new UtilizatorMapper());
		return utilizatori;
	}

}
