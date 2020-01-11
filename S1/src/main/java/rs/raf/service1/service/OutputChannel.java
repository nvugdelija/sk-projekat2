package rs.raf.service1.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputChannel {

    String CHANNEL_NAME = "S1";

    @Output(CHANNEL_NAME)
    MessageChannel output();

}
