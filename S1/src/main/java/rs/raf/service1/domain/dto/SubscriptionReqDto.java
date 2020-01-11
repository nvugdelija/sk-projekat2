package rs.raf.service1.domain.dto;

import lombok.Data;

@Data
public class SubscriptionReqDto {

    private String email;

    private String list;

    private String frequency;

}
