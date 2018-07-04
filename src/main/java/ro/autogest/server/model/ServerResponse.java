package ro.autogest.server.model;

public class ServerResponse {

	private String message;
	private Boolean succes;
	public String getMessage() {
		return message;
	}
	
	
	public ServerResponse(){}
	public ServerResponse(String message, Boolean succes) {
		super();
		this.message = message;
		this.succes = succes;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSucces() {
		return succes;
	}
	public void setSucces(Boolean succes) {
		this.succes = succes;
	}

	
	
}
