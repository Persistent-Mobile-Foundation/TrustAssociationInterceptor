package com.psl;

import org.glassfish.jersey.servlet.ServletContainer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RestServlet implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        configureServlet(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup if needed
    }

    // Programmatic servlet registration
    private void configureServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic jerseyServlet =
                servletContext.addServlet("ServicesServlet", ServletContainer.class);

        // Point to ResourceConfig class
        jerseyServlet.setInitParameter("jakarta.ws.rs.Application", App.class.getName());

        // Enable multipart config
        jerseyServlet.setMultipartConfig(new MultipartConfigElement(
                null,        // location
                20971520L,   // max file size (20MB)
                41943040L,   // max request size (40MB)
                1048576      // file size threshold (1MB)
        ));

        // Map servlet to URL pattern
        jerseyServlet.addMapping("/rest/*");

        // Load on startup
        jerseyServlet.setLoadOnStartup(1);
    }
}
