package ro.autogest.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.autogest.server.model.Taxa;

@Repository
public class TaxaDAOImpl implements TaxaDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void create(Taxa taxa) {
		
		String SQL = "insert into taxa (id_vehicul, tip_taxa, cost_taxa, data_creare, "
				+ "data_expirare) values (?, ?, ?, ?,?)";

		jdbcTemplate.update(SQL, taxa.getIdVehicul(),taxa.getTipTaxa(),taxa.getCostTaxa(),taxa.getDataCreare(),taxa.getDataExpirare());
		
	}

	
}
