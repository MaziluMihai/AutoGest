package ro.autogest.server.model;

public class Asigurare {

	private Integer idUtilizator;
	private Integer idVehicul;
	private String tipAsigurare;
	private Integer costAsigurare;
	private String companiaAsiguratoare;
	private String dataCreare;
	private String dataExpirare;

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

	public String getDataCreare() {
		return dataCreare;
	}

	public void setDataCreare(String dataCreare) {
		this.dataCreare = dataCreare;
	}

	public String getDataExpirare() {
		return dataExpirare;
	}

	public void setDataExpirare(String dataExpirare) {
		this.dataExpirare = dataExpirare;
	}

}
