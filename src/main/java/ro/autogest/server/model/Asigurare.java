package ro.autogest.server.model;

import java.util.Date;

public class Asigurare {

	private Integer idUtilizator;
	private Integer idVehicul;
	private String tipAsigurare;
	private Integer costAsigurare;
	private String companiaAsiguratoare;
	private Date dataCreare;
	private Date dataExpirare;

	public Integer getIdUtilizator() {
		return idUtilizator;
	}

	public void setIdUtilizator(Integer idUtilizator) {
		this.idUtilizator = idUtilizator;
	}

	public Integer getIdVehicul() {
		return idVehicul;
	}

	public void setIdVehicul(Integer idVehicul) {
		this.idVehicul = idVehicul;
	}

	public String getTipAsigurare() {
		return tipAsigurare;
	}

	public void setTipAsigurare(String tipAsigurare) {
		this.tipAsigurare = tipAsigurare;
	}

	public Integer getCostAsigurare() {
		return costAsigurare;
	}

	public void setCostAsigurare(Integer costAsigurare) {
		this.costAsigurare = costAsigurare;
	}

	public String getCompaniaAsiguratoare() {
		return companiaAsiguratoare;
	}

	public void setCompaniaAsiguratoare(String companiaAsiguratoare) {
		this.companiaAsiguratoare = companiaAsiguratoare;
	}

	public Date getDataCreare() {
		return dataCreare;
	}

	public void setDataCreare(Date dataCreare) {
		this.dataCreare = dataCreare;
	}

	public Date getDataExpirare() {
		return dataExpirare;
	}

	public void setDataExpirare(Date dataExpirare) {
		this.dataExpirare = dataExpirare;
	}


}
