package com.webclient.springboot;

import com.webclient.springboot.stores.client.StoreClient;
import com.webclient.springboot.stores.wsdl.GetStoreResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebClientExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebClientExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(StoreClient storeClient) {
        return args -> {
            Integer id = 3;
            GetStoreResponse response1 = storeClient.getStore(id);
            System.out.println("Complex :"+response1.getStore().getName());
            GetStoreResponse response2 = storeClient.getStoreAlt(id);
            System.out.println("Simple :"+response2.getStore().getName());
        };
    }

}
