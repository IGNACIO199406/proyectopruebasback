package com.proyectos.app.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.proyectos.app.excepcion.ResourceNotFoundException;
import com.proyectos.app.excepcion.UnauthorizedException;
import com.proyectos.app.util.Constants;
@Component
public class ApiKey {

	 public void getApiKey()throws ResourceNotFoundException {
		
		 
		 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = (HttpServletRequest) attr.getRequest();
			String authTokenHeader = request.getHeader("api-Key-prueba");
			
			if(authTokenHeader==null || authTokenHeader.equals("") || !Constants.apiKey.equals(authTokenHeader)) {
				throw new UnauthorizedException("No estas autorizado api-key");
			}

	    }
}
