package ro.autogest.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicul {

	private Integer id;
	private Integer id_utilizator;
	private String numar_inmatriculare;
	private String marca;
	private String motorizare;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_utilizator() {
		return id_utilizator;
	}

	public void setId_utilizator(Integer id_utilizator) {
		this.id_utilizator = id_utilizator;
	}

	public String getNumar_inmatriculare() {
		return numar_inmatriculare;
	}

	public void setNumar_inmatriculare(String numar_inmatriculare) {
		this.numar_inmatriculare = numar_inmatriculare;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMotorizare() {
		return motorizare;
	}

	public void setMotorizare(String motorizare) {
		this.motorizare = motorizare;
	}

}
