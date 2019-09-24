package com.synergisticit.onlinebanking.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
			throws IOException, ServletException {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null){
			//DO AUTHENTICATION
			System.out.println(authentication.getName()+" is not allowed to access "+request.getRequestURL());
		}
		response.sendRedirect(request.getContextPath()+"/accessDenied");
		
	}

}
