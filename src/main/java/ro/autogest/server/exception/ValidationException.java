package ro.autogest.server.exception;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationException extends Exception implements ExceptionMapper<ValidationException> {

	private String message;
	
	public ValidationException(){
		
	}
	
	public ValidationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response toResponse(ValidationException exception) {
		return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(exception.getMessage())
                .type("text/plain").build();
	}
	
	
}
