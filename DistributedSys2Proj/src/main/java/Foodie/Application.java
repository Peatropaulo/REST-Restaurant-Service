package Foodie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
//https://api.geocod.io/v1.3/geocode?q=1109+N+Highland+St%2c+Arlington+VA&api_key=YOUR_API_KEY
//4455573350ee5e5112f2f53e53f5be4b021bb5e

//https://developers.zomato.com/api/v2.1/geocode?
//https://developers.zomato.com/api/v2.1/geocode?lat=40.500820&lon=-74.447395
//02e7bb7ac9b7fe59207f9eb1ab4b1907