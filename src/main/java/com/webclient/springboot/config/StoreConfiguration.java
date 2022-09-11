package com.webclient.springboot.config;

import com.webclient.springboot.stores.client.StoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class StoreConfiguration {

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
        wss4jSecurityInterceptor.setSecurementActions("Timestamp UsernameToken");
        wss4jSecurityInterceptor.setSecurementUsername("admin");
        wss4jSecurityInterceptor.setSecurementPassword("secret");
        return wss4jSecurityInterceptor;
    }

    @Bean
    public Jaxb2Marshaller storeMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.webclient.springboot.stores.wsdl");
        return marshaller;
    }

    @Bean
    public StoreClient storeClient() {
        StoreClient client = new StoreClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(storeMarshaller());
        client.setUnmarshaller(storeMarshaller());
        ClientInterceptor[] interceptors = new ClientInterceptor[]{securityInterceptor()};
        client.setInterceptors(interceptors);
        return client;
    }

}
