package ro.autogest.server.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ro.autogest.rest.mapper.UtilizatorMapper;
import ro.autogest.server.model.Utilizator;

public class UtilizatorJDBCTemplate implements UtilizatorDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		this.dataSource=ds;
		this.jdbcTemplate=new JdbcTemplate(ds);
		
	}

	public void create(String nume, String email) {
		String SQL = "insert into Utilizator (nume, email) values (?, ?)";
	      
	      jdbcTemplate.update( SQL, nume, email);
	      System.out.println("Created Record Name = " + nume + " Age = " + email);
	      return;

		
	}

	public Utilizator getUtilizator(Integer id) {
		String sql="SELECT * FROM Utilizator WHERE id_utilizator = ?";
		
		return jdbcTemplate.queryForObject(sql, Utilizator.class);
	}

	public List<Utilizator> listaUtilizatori() {
		 String  sql="select * from Utilizator";
	      List <Utilizator> utilizatori = jdbcTemplate.query(sql, new UtilizatorMapper());
	      return utilizatori;
	}

}
