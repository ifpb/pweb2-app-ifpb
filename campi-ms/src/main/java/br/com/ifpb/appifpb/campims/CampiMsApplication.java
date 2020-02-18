package br.com.ifpb.appifpb.campims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CampiMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampiMsApplication.class, args);
    }

}
