package com.sbz.learnings.springjpahibernate.config;

import java.io.IOException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@Configuration
public class RestConfig {


    @Bean
    public RestTemplate myRestTemplate(InterceptorTest interceptorTest) {
        return new RestTemplateBuilder()
                .interceptors(interceptorTest)
                .build();
    }

    @Bean
    public ObjectMapper myObjectMapper() {
        return new Jackson2ObjectMapperBuilder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .build();
    }

    @Bean
    public InterceptorTest interceptorTest() {
        return new InterceptorTest();
    }

    public static class InterceptorTest implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            System.out.println("REQUEST--------------------> "+request.getMethod());
            request.getHeaders().add("Message_id", "123456");
            ClientHttpResponse response = execution.execute(request, body);
            response.getHeaders().add("TEST", "TEST");
            response.getHeaders().add("Message_id", "123456");
            System.out.println("RESPONSE--------------------> "+ response.getStatusCode());
            return response;
        }
    }

}
