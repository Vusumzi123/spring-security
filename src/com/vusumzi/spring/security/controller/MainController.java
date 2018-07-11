package com.vusumzi.spring.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.servlet.ModelAndView;

public interface MainController {
	
	public ModelAndView home(HttpServletRequest request);
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView privateHome(HttpServletRequest request, HttpServletResponse response);
	public ModelAndView login(HttpServletRequest request);

}
