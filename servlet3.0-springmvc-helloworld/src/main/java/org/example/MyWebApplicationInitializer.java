package org.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        XmlWebApplicationContext xmlApplicationContext = new XmlWebApplicationContext();
        xmlApplicationContext.setConfigLocation("classpath:ApplicationContext.xml");
        xmlApplicationContext.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(xmlApplicationContext));
        DispatcherServlet dispatcherServlet = new DispatcherServlet(xmlApplicationContext);
        dispatcherServlet.setContextConfigLocation("classpath:springmvc.xml");
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        dispatcherServlet.refresh();
    }
}