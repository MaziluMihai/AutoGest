package ro.autogest.server.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundException extends Exception implements ExceptionMapper<NotFoundException> {

	private String message;
	
	public NotFoundException(){
		
	}
	
	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response toResponse(NotFoundException exception) {
		return Response.status(404).entity(exception.getMessage())
                .type("text/plain").build();
	}
	
	
}
