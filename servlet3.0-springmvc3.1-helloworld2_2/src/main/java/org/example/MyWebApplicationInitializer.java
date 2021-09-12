package org.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
    	AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    	ac.register(AppConfig.class);
    	
        DispatcherServlet d = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", d);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}




