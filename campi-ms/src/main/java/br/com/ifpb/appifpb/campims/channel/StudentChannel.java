package br.com.ifpb.appifpb.campims.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StudentChannel {

    String INPUT = "student-info";

    @Input(INPUT)
    SubscribableChannel studentChannelReply();
}
