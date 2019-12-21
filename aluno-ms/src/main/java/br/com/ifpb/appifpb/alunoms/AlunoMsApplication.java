package br.com.ifpb.appifpb.alunoms;

import br.com.ifpb.appifpb.alunoms.channel.UserChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(UserChannel.class)
public class AlunoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoMsApplication.class, args);
	}



}
