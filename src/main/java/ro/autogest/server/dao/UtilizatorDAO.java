package ro.autogest.server.dao;

import java.util.List;

import ro.autogest.server.model.Utilizator;

public interface UtilizatorDAO {


  public void create(String nume, String email);
  public Utilizator getUtilizator(Integer id);
  public Utilizator getUtilizatorByEmail(String email);
  
  public List<Utilizator> listaUtilizatori();

}
