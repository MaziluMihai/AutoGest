package ro.autogest.server.model;

import java.util.Date;



public class IntrareService {

	private String tipReparatie;
	private Integer costReparatie;
	private Integer idVehicul;
	private Integer idService;
	private Date dataIntrare;
	private Date dataIesire;

	public String getTipReparatie() {
		return tipReparatie;
	}

	public void setTipReparatie(String tipReparatie) {
		this.tipReparatie = tipReparatie;
	}

	

	public Integer getCostReparatie() {
		return costReparatie;
	}

	public void setCostReparatie(Integer costReparatie) {
		this.costReparatie = costReparatie;
	}

	public Integer getIdVehicul() {
		return idVehicul;
	}

	public void setIdVehicul(Integer idVehicul) {
		this.idVehicul = idVehicul;
	}

	public Integer getIdService() {
		return idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}

	public Date getDataIntrare() {
		return dataIntrare;
	}

	public void setDataIntrare(Date dataIntrare) {
		this.dataIntrare = dataIntrare;
	}

	public Date getDataIesire() {
		return dataIesire;
	}

	public void setDataIesire(Date dataIesire) {
		this.dataIesire = dataIesire;
	}

	


	

}
