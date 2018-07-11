package com.vusumzi.spring.security.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vusumzi.spring.security.controller.MainController;

@Controller
public class MainControllerImpl implements MainController{
	@Override
	@RequestMapping(value="/", method=RequestMethod.GET)  
    public ModelAndView home(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("home");	
        return model;  
    }  
    
	@Override
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView privateHome(HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView model = new ModelAndView("privatePage");
        return model;
    }
    
	@Override
    @RequestMapping(value="/login", method=RequestMethod.POST)  
    public ModelAndView login(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");	
        return model;  
    }
}
