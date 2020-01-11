package rs.raf.service1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rs.raf.service1.domain.dto.CouponDto;

import java.util.List;

@FeignClient(name = "service2")
public interface Service2 {

    @GetMapping("/coupon/findAll")
    List<CouponDto> findAll();

    @GetMapping("/coupon/findByCountry")
    List<CouponDto> findByCountry(@RequestParam(name = "country") String country);
}
