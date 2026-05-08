package com.psl;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.psl.rest.HelloResource;

import jakarta.ws.rs.ApplicationPath;

/**
 * Hello world!
 *
 */
@ApplicationPath("/rest")
public class App extends ResourceConfig
{
    public App() {
        super();
        register(HelloResource.class);
        register(RolesAllowedDynamicFeature.class);
    }
}
