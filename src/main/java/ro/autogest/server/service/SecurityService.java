package ro.autogest.server.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.autogest.server.dao.UtilizatorDAO;
import ro.autogest.server.exception.NotAuthorizedException;
import ro.autogest.server.model.CredentialeLogin;
import ro.autogest.server.model.Utilizator;
import ro.autogest.server.utils.Utils;

@Service
public class SecurityService {

	Logger LOGGER = Logger.getLogger(SecurityService.class);
	
	@Autowired
	UtilizatorService utilizatorService;
	

	@Autowired
	private UtilizatorDAO utilizatorDAO;
	
	public Integer login(CredentialeLogin credentialeLogin) throws NotAuthorizedException {
		if(utilizatorService.existaUser(credentialeLogin.getEmail())){
			Utilizator utilizator = utilizatorDAO.getUtilizatorByEmail(credentialeLogin.getEmail());
			String hashedStoredPassword = utilizator.getParola();
			String hashedSentPassword = Utils.hashPassword(credentialeLogin.getParola());
			if(hashedStoredPassword.equalsIgnoreCase(hashedSentPassword)) {
				Integer token = Utils.generateToken();
				Calendar gregorianCalendar = GregorianCalendar.getInstance();
				gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, 3);
				Date tokenExpirationDate = gregorianCalendar.getTime();
				utilizator.setToken(token);
				utilizator.setTokenDate(tokenExpirationDate);
				utilizatorDAO.update(utilizator, utilizator.getId());
				
				return token;
				
			}
		}
		throw new NotAuthorizedException("Userul sau Parola sunt invalide");
	}
	
	public boolean checkToken(String email, String token) {
		
		Utilizator utilizator = utilizatorDAO.getUtilizatorByEmail(email);
		
		if(utilizator == null) {
			LOGGER.info("Utilizatorul cu adresa de email " + email + " nu exista");
			return false;
		}
		
		Integer storedToken = utilizator.getToken();
		
		if(storedToken.equals(Integer.parseInt(token)) && utilizator.getTokenDate().after(new Date())) {
			return true;
		}
		
		return false;
	}
}
