package ro.autogest.server.model;

import java.util.List;

public class VehiculListResponse {

	private List<Vehicul> response;

	public VehiculListResponse(){}
	
	public VehiculListResponse(List<Vehicul> response) {
		super();
		this.response = response;
	}

	public List<Vehicul> getResponse() {
		return response;
	}

	public void setResponse(List<Vehicul> response) {
		this.response = response;
	}
	
	
}
