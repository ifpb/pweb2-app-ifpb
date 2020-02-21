package br.com.ifpb.appifpb.campims;

import br.com.ifpb.appifpb.campims.channel.CampiChannel;
import br.com.ifpb.appifpb.campims.channel.RegChannel;
import br.com.ifpb.appifpb.campims.channel.StudentChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding({StudentChannel.class, CampiChannel.class, RegChannel.class})
public class CampiMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampiMsApplication.class, args);
    }

}
