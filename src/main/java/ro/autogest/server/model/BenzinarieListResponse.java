package ro.autogest.server.model;

import java.util.List;

public class BenzinarieListResponse {

	private List<Benzinarie> response;

	public BenzinarieListResponse(){}
	
	public BenzinarieListResponse(List<Benzinarie> response) {
		super();
		this.response = response;
	}

	public List<Benzinarie> getResponse() {
		return response;
	}

	public void setResponse(List<Benzinarie> response) {
		this.response = response;
	}
	
	
}
