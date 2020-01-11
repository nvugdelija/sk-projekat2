package rs.raf.service1.domain.dto;

import lombok.Getter;
import rs.raf.service1.domain.Subscription;

@Getter
public class SubscriptionResDto {

    private String userEmail;

    private String list;

    public SubscriptionResDto(Subscription subscription){
        this.list = subscription.getList();
        this.userEmail = subscription.getUser().getEmail();
    }

}
