package ro.autogest.server.model;



public class IntrareService {

	private String tipReparatie;
	private String costReparatie;
	private Integer idVehicul;
	private Integer idService;
	private String dataIntrare;
	private String dataIesire;

	public String getTipReparatie() {
		return tipReparatie;
	}

	public void setTipReparatie(String tipReparatie) {
		this.tipReparatie = tipReparatie;
	}

	public String getCostReparatie() {
		return costReparatie;
	}

	public void setCostReparatie(String costReparatie) {
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

	public String getDataIntrare() {
		return dataIntrare;
	}

	public void setDataIntrare(String dataIntrare) {
		this.dataIntrare = dataIntrare;
	}

	public String getDataIesire() {
		return dataIesire;
	}

	public void setDataIesire(String dataIesire) {
		this.dataIesire = dataIesire;
	}



	

}
