package ro.autogest.server.model;

import java.util.List;

public class UtilizatorListResponse {

	private List<Utilizator> response;

	public UtilizatorListResponse(){}
	
	public UtilizatorListResponse(List<Utilizator> response) {
		super();
		this.response = response;
	}

	public List<Utilizator> getResponse() {
		return response;
	}

	public void setResponse(List<Utilizator> response) {
		this.response = response;
	}
	
	
}
