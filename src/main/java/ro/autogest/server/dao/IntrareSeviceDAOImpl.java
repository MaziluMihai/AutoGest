package ro.autogest.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.dao.mapper.IntrareServiceMapper;
import ro.autogest.server.model.IntrareService;

@Repository
public class IntrareSeviceDAOImpl implements IntrareServiceDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(IntrareService intrareService) {

		String SQL = "insert into intrare_service (id_vehicul, id_service, tip_reparatie, cost_reparatie, data_intrare,data_iesire ) values (?, ?, ?, ?,?,?)";

		jdbcTemplate.update(SQL, intrareService.getIdVehicul(), intrareService.getIdService(), intrareService.getTipReparatie(),
				intrareService.getCostReparatie(), intrareService.getDataIntrare(), intrareService.getDataIesire());
		
	}

	public List<IntrareService> findByVehiculId(int idVehicul) {
		String sql = "SELECT * FROM Intrare_Service WHERE id_vehicul = ?";

		try {
			return jdbcTemplate.query(sql, new Object[] { idVehicul }, new IntrareServiceMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
