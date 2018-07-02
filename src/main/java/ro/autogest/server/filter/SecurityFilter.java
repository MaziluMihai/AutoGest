package ro.autogest.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ro.autogest.server.service.SecurityService;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if("/user/login".equals(((HttpServletRequest)request).getPathInfo())) {
			chain.doFilter(request, response);
		} else {
			String emailHeader = ((HttpServletRequest)request).getHeader("Email");
			String authorizationHeader = ((HttpServletRequest)request).getHeader("Authorization");
			
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(((HttpServletRequest)request).getSession().getServletContext());
			SecurityService securityService = webApplicationContext.getBean(SecurityService.class);
			
			if(securityService.checkToken(emailHeader, authorizationHeader)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse)response).setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}
		
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
