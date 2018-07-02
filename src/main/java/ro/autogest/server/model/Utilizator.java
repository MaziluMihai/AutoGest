package ro.autogest.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Utilizator {
	private Integer id;
	private String nume;
	private String prenume;
	private String tip_utilizator;
	private String email;
	private String parola;
	private String functia;
	private Integer telefon;
	

	public String getTip_utilizator() {
		return tip_utilizator;
	}

	public void setTip_utilizator(String tip_utilizator) {
		this.tip_utilizator = tip_utilizator;
	}

	public Integer getTelefon() {
		return telefon;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getFunctia() {
		return functia;
	}

	public void setFunctia(String functia) {
		this.functia = functia;
	}

	
}
