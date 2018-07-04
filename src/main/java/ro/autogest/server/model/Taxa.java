package ro.autogest.server.model;

public class Taxa {

	private Integer idVehicul;
	private String tipTaxa;
	private Integer costTaxa;
	private String dataCreare;
	private String dataExpirare;

	public Integer getIdVehicul() {
		return idVehicul;
	}

	public void setIdVehicul(Integer idVehicul) {
		this.idVehicul = idVehicul;
	}

	public String getTipTaxa() {
		return tipTaxa;
	}

	public void setTipTaxa(String tipTaxa) {
		this.tipTaxa = tipTaxa;
	}

	public Integer getCostTaxa() {
		return costTaxa;
	}

	public void setCostTaxa(Integer costTaxa) {
		this.costTaxa = costTaxa;
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
