package org.example;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(value= {NpfWebApplicationInitializer.class})
public class NpfSpringServletContainerInitializer implements ServletContainerInitializer {

	
	public void onStartup(Set<Class<?>> npfWebApplicationInitializer, ServletContext servletContext)throws ServletException{
		List<NpfWebApplicationInitializer> initializers = new LinkedList<NpfWebApplicationInitializer>();
		if (npfWebApplicationInitializer != null) {
			for (Class<?> waiClass : npfWebApplicationInitializer) {
				if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) 
						&& NpfWebApplicationInitializer.class.isAssignableFrom(waiClass)) {
					try {
						initializers.add((NpfWebApplicationInitializer) waiClass.newInstance());
					}catch (Throwable ex) {
						throw new ServletException("Failed to instantiate NpfWebApplicationInitializer class", ex);
					}
				}
			}
		}
		if (initializers.isEmpty()) {
			servletContext.log("No NpfWebApplicationInitializer types detected on classpath");
			return;
		}
		Collections.sort(initializers, new AnnotationAwareOrderComparator());
		servletContext.log("NpfWebApplicationInitializer detected on classpath: " + initializers);
		for (NpfWebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}
}