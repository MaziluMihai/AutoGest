package ro.autogest.server.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

@Provider
public class GenericException extends Throwable implements ExceptionMapper<Throwable> {
	private static final long serialVersionUID = 1L;

	Logger LOGGER = Logger.getLogger(GenericException.class);
	
	public Response toResponse(Throwable exception) {
		LOGGER.error("GenericException occured ",exception);
		return Response.status(500).entity("Serverul a intors o eroare! Va rugam reincercati!").type("text/plain").build();
	}

}
