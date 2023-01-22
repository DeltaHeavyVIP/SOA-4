package com.example.gateway.configuration;

import com.example.gateway.service.OperationService;
import com.example.gateway.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class GatewayClientConfig {
    @Value("${service.first-service.url}")
    private String url;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("entity");
        return marshaller;
    }

    @Bean
    public OperationService countryClient(Jaxb2Marshaller marshaller) {
        OperationService operationService = new OperationService();
        operationService.setDefaultUri(url);
        operationService.setMarshaller(marshaller);
        operationService.setUnmarshaller(marshaller);
        operationService.setMapper(new ModelMapper());
        return operationService;
    }
}
