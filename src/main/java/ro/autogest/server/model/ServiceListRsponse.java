package ro.autogest.server.model;

import java.util.List;

public class ServiceListRsponse {

	private List<Service> response;

	public ServiceListRsponse(List<Service> response) {
		super();
		this.response = response;
	}

	public List<Service> getResponse() {
		return response;
	}

	public void setResponse(List<Service> response) {
		this.response = response;
	}
}
