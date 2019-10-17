package com.spring.security;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.security.config.WebSecurityConfig;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override    
    protected Class<?>[] getRootConfigClasses() {    
        return new Class[] { WebSecurityConfig.class };    
    }    
    @Override    
    protected Class<?>[] getServletConfigClasses() {    
        // TODO Auto-generated method stub    
        return null;    
    }    
    @Override    
    protected String[] getServletMappings() {    
        return new String[] { "/" };    
    }    
}
