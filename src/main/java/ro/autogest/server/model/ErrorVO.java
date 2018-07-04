package ro.autogest.server.model;

public class ErrorVO {

	public int errorCode;
	public String errorMessage;
	
	
	
	public ErrorVO(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
