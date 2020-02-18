package br.com.ifpb.appifpb.campims.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RegChannel {

    String INPUT = "registration-info";

    @Input(INPUT)
    SubscribableChannel regChannelReply();

}
