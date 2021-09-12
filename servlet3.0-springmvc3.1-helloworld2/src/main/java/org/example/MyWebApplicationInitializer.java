package org.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
    	AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    	ac.register(AppConfig.class);
    	servletContext.addListener(new ContextLoaderListener(ac));
    	
        DispatcherServlet d = new DispatcherServlet();
        d.setContextClass(AnnotationConfigWebApplicationContext.class);
        d.setContextConfigLocation(AppMvcConfig.class.getCanonicalName());
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", d);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}






