package org.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

public class MyNpfWebApplicationInitializer implements NpfWebApplicationInitializer{

	public void onStartup(ServletContext ctx) {
		ctx.setInitParameter("contextConfigLocation", "classpath:applicationContext.xml");
        ctx.addListener(new ContextLoaderListener());
        
        DispatcherServlet d = new DispatcherServlet();
        d.setContextConfigLocation("classpath:dispatcherServlet-servlet.xml");
        ServletRegistration.Dynamic registration = ctx.addServlet("dispatcherServlet", d);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
	}

}
