package br.com.ifpb.appifpb.campims.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CampiChannel {

    String INPUT = "campi-info";

    @Input(INPUT)
    SubscribableChannel campiChannelReply();

}
