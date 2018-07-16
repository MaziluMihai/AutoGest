package ro.autogest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.dao.mapper.BenzinarieMapper;
import ro.autogest.server.dao.mapper.UtilizatorMapper;
import ro.autogest.server.model.Benzinarie;
import ro.autogest.server.model.Utilizator;

@Repository
public class BenzinarieDAOImpl implements BenzinarieDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(String denumire, String locatie, String telefon, String email) {
		String SQL = "insert into Benzinarie (denumire, locatie, telefon, email) values (?, ?, ?, ?)";

		jdbcTemplate.update(SQL, denumire, locatie, telefon, email);
		return;
	}

	public Benzinarie getBenzinarie(Integer id) {
		String sql = "SELECT * FROM Benzinarie WHERE id_benzinarie = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BenzinarieMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Benzinarie> listaBenzinarii() {
		String sql = "select * from Benzinarie";
		List<Benzinarie> benzinarii = jdbcTemplate.query(sql, new BenzinarieMapper());
		return benzinarii;
	}

	public void update(Integer id, String denumire, String locatie, String telefon, String email) {
		String SQL = "update  Benzinarie set denumire=?, locatie=?, telefon=?, email=? where id_benzinarie=?";

		jdbcTemplate.update(SQL, denumire, locatie, telefon, email, id);
		return;

	}

	public void delete(Integer id) {
		String SQL = "delete from Benzinarie where id_benzinarie=?";
		jdbcTemplate.update(SQL, id);
		return;

	}

	public Benzinarie getBenzinarieByEmail(String email) {
		String sql = "SELECT * FROM Benzinarie WHERE email = ?";

		List<Benzinarie> benzinarii = jdbcTemplate.query(sql, new Object[] { email }, new BenzinarieMapper());

		if (benzinarii == null || (benzinarii != null && benzinarii.size() == 0)) {
			return null;
		}
		return benzinarii.get(0);

	}

}
