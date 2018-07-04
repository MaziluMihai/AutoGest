package ro.autogest.server.model;

import java.util.Date;

public class Taxa {

	private Integer idVehicul;
	private String tipTaxa;
	private Integer costTaxa;
	private Date dataCreare;
	private Date dataExpirare;

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
