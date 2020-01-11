package rs.raf.service1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rs.raf.service1.domain.dto.CouponDto;
import rs.raf.service1.domain.dto.MailDto;
import rs.raf.service1.domain.dto.SubscriptionResDto;

import java.util.List;

@Component
@EnableBinding(OutputChannel.class)
@RequiredArgsConstructor
public class Scheduler {

    private final OutputChannel outputChannel;

    private final Service2 service2;
    private final SubscriptionService subscriptionService;

    private final ObjectMapper objectMapper;

    @Scheduled(fixedDelay = 60000)
    public void sendUpdates() throws JsonProcessingException {
        List<SubscriptionResDto> subscriptions = subscriptionService.findAll();

        for(SubscriptionResDto s : subscriptions){
            List<CouponDto> coupons = service2.findByCountry(s.getList());
            StringBuilder sb = new StringBuilder();
            for(CouponDto coupon : coupons)
                sb.append(objectMapper.writeValueAsString(coupon));
            String body = sb.toString();
            String title = s.getList() + " list news";

            MailDto mailDto = new MailDto(s.getUserEmail(), title, body);
            outputChannel.output().send(MessageBuilder.withPayload(mailDto).build());
        }
    }

}
