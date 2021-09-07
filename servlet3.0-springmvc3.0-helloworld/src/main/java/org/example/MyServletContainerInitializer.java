package org.example;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyServletContainerInitializer implements ServletContainerInitializer {

	
	public void onStartup(Set<Class<?>> c, ServletContext ctx)throws ServletException{
		ctx.setInitParameter("contextConfigLocation", "classpath:applicationContext.xml");
        ctx.addListener(new ContextLoaderListener());
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setContextConfigLocation("classpath:dispatcherServlet-servlet.xml");
        ServletRegistration.Dynamic registration = ctx.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
	}
}