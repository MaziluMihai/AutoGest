package ro.autogest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.dao.mapper.ServiceMapper;
import ro.autogest.server.model.Service;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(String denumire, String locatie, String telefon, String email) {

		String SQL = "insert into service (denumire, locatie, telefon, email) values (?, ?, ?, ?)";

		jdbcTemplate.update(SQL, denumire, locatie, telefon, email);
	}

	public Service getService(Integer id) {
		String sql = "SELECT * FROM service WHERE id_service = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new ServiceMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public List<Service> listaServiceuri() {

		String sql = "select * from Service";
		List<Service> serviceuri = jdbcTemplate.query(sql, new ServiceMapper());
		return serviceuri;
	}

}
