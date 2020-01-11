package rs.raf.service1.domain.dto;

import lombok.Data;
import rs.raf.service1.domain.Subscription;
import rs.raf.service1.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserResDto {

    private String firstName;

    private String lastName;

    private String email;

    //private List<String> subscriptions;

    public UserResDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        //this.subscriptions = user.getSubscriptions().stream().map(Subscription::getList).collect(Collectors.toList());
    }

}
