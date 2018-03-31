package ro.autogest.server.dao;

import java.util.List;

import javax.sql.DataSource;

import ro.autogest.server.model.Utilizator;

public interface UtilizatorDAO {
	 /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public void create(String nume, String email);
  public Utilizator getUtilizator(Integer id);
  
  /** 
    * This is the method to be used to list down
    * all the records from the Student table.
  */
  public List<Utilizator> listaUtilizatori();

}
