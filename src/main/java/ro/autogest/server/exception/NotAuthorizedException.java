package ro.autogest.server.exception;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotAuthorizedException extends Exception implements ExceptionMapper<NotAuthorizedException> {

	private String message;
	
	public NotAuthorizedException(){
		
	}
	
	public NotAuthorizedException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response toResponse(NotAuthorizedException exception) {
		return Response.status(HttpServletResponse.SC_FORBIDDEN).entity(exception.getMessage())
                .type("text/plain").build();
	}
	
	
}
