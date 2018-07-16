package ro.autogest.server.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ro.autogest.server.model.InregistrareAlimentare;

public class InregistrareAlimentareMapper implements org.springframework.jdbc.core.RowMapper<InregistrareAlimentare>{

	public InregistrareAlimentare mapRow(ResultSet rs, int row) throws SQLException {
		InregistrareAlimentare b =new InregistrareAlimentare();
		
		b.setTipCarburant(rs.getString("tip_carburant"));
		b.setCantitate(rs.getDouble("cantitate"));
		b.setKm(rs.getInt("numar_km"));
		b.setPret(rs.getDouble("pret_litru"));
		return b;
}
}
