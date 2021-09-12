package org.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        DispatcherServlet d = new DispatcherServlet();
        d.setContextConfigLocation("classpath:dispatcherServlet-servlet.xml");
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", d);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}