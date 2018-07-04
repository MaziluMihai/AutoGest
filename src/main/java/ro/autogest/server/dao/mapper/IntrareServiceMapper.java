package ro.autogest.server.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ro.autogest.server.model.IntrareService;

public class IntrareServiceMapper implements RowMapper<IntrareService> {
	

	public IntrareService mapRow(ResultSet rs, int row) throws SQLException {
		IntrareService b =new IntrareService();
		
		b.setCostReparatie(rs.getInt("cost_reparatie"));
		b.setDataIntrare(rs.getDate("data_intrare"));
		b.setDataIesire(rs.getDate("data_iesire"));
		b.setIdService(rs.getInt("id_vehicul"));
		b.setIdVehicul(rs.getInt("id_service"));
		b.setTipReparatie(rs.getString("tip_reparatie"));

		return b;
}
}