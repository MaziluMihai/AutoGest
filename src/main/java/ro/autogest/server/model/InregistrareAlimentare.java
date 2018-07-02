package ro.autogest.server.model;

public class InregistrareAlimentare {

	private String tipCarburant;
	private Integer pret;
	private Integer cantitate;
	private Integer km;
	private Integer idVehicul;
	private Integer idBenzinarie;
	private Integer idCard;
	
	
	public String getTipCarburant() {
		return tipCarburant;
	}
	public void setTipCarburant(String tipCarburant) {
		this.tipCarburant = tipCarburant;
	}
	public Integer getPret() {
		return pret;
	}
	public void setPret(Integer pret) {
		this.pret = pret;
	}
	public Integer getCantitate() {
		return cantitate;
	}
	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}
	public Integer getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public Integer getIdVehicul() {
		return idVehicul;
	}
	public void setIdVehicul(Integer idVehicul) {
		this.idVehicul = idVehicul;
	}
	public Integer getIdBenzinarie() {
		return idBenzinarie;
	}
	public void setIdBenzinarie(Integer idBenzinarie) {
		this.idBenzinarie = idBenzinarie;
	}
	public Integer getIdCard() {
		return idCard;
	}
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	
	
	
	
}
