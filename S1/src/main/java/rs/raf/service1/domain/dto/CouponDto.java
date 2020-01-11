package rs.raf.service1.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CouponDto {

    private String store_name;

    private String store_country;

    private String code;

    private String description;

}
