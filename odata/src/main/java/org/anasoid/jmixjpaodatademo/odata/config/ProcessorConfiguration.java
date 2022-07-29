package org.anasoid.jmixjpaodatademo.odata.config;

import org.anasoid.jmixjpaodatademo.odata.edm.mapper.api.APINameBuilder;
import org.anasoid.jmixjpaodatademo.odata.jpa.processor.core.api.JPACUDRequestHandler;
import org.apache.olingo.commons.api.ex.ODataException;
import org.apache.olingo.server.api.debug.DefaultDebugSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.EntityManagerFactory;

import com.sap.olingo.jpa.processor.core.api.JPAODataRequestContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataServiceContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import com.sap.olingo.jpa.processor.core.api.example.JPAExampleCUDRequestHandler;


import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

@Configuration
public class ProcessorConfiguration {
    @Value("${odata.jpa.punit_name}")
    private String punit;
    @Value("${odata.jpa.root_packages}")
    private String rootPackages;

    @Bean
    public JPAODataSessionContextAccess sessionContext(@Autowired final EntityManagerFactory emf) throws ODataException {

        return JPAODataServiceContext.with()
                .setPUnit(punit)
                .setEntityManagerFactory(emf)
                .setTypePackage(rootPackages)
                .setRequestMappingPath("odata")
                .setEdmNameBuilder(new APINameBuilder(punit))
                .build();
    }

    @Bean
    @Scope(scopeName = SCOPE_REQUEST)
    public JPAODataRequestContext requestContext() {

        return JPAODataRequestContext.with()
                .setCUDRequestHandler(new JPACUDRequestHandler())
                .setDebugSupport(new DefaultDebugSupport())
                .build();
    }
}