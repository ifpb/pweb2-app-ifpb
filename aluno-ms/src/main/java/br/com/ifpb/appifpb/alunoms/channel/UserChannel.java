package br.com.ifpb.appifpb.alunoms.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserChannel {

    String INPUT = "receptor-aluno";

    String OUTPUT = "receptor-matricula";

    @Input(INPUT)
    SubscribableChannel userChannelReply();

    @Output(OUTPUT)
    MessageChannel userChannel();

}
