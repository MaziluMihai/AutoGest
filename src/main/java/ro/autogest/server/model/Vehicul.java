package ro.autogest.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicul {

	private Integer id;
	private Integer idUtilizator;
	private String numarInmatriculare;
	private String marca;
	private String modelul;
	private String statusVehicul;
	private String tip;
	private String motorizare;
	private Integer anFabricatie;
	private Integer consum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUtilizator() {
		return idUtilizator;
	}
	public void setIdUtilizator(Integer idUtilizator) {
		this.idUtilizator = idUtilizator;
	}
	public String getNumarInmatriculare() {
		return numarInmatriculare;
	}
	public void setNumarInmatriculare(String numarInmatriculare) {
		this.numarInmatriculare = numarInmatriculare;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelul() {
		return modelul;
	}
	public void setModelul(String modelul) {
		this.modelul = modelul;
	}
	public String getStatusVehicul() {
		return statusVehicul;
	}
	public void setStatusVehicul(String statusVehicul) {
		this.statusVehicul = statusVehicul;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getMotorizare() {
		return motorizare;
	}
	public void setMotorizare(String motorizare) {
		this.motorizare = motorizare;
	}
	public Integer getAnFabricatie() {
		return anFabricatie;
	}
	public void setAnFabricatie(Integer anFabricatie) {
		this.anFabricatie = anFabricatie;
	}
	public Integer getConsum() {
		return consum;
	}
	public void setConsum(Integer consum) {
		this.consum = consum;
	}


}
