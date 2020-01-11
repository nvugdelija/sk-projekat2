package rs.raf.service1.ctrl;

import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import rs.raf.service1.domain.dto.SubscriptionReqDto;
import rs.raf.service1.domain.dto.SubscriptionResDto;
import rs.raf.service1.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping(value = "/sub")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class SubCtrl {

    private final SubscriptionService subscriptionService;

    @GetMapping("/findAll")
    public List<SubscriptionResDto> findAll() {
        return subscriptionService.findAll();
    }

    @PostMapping("/save")
    public SubscriptionResDto save(@RequestBody SubscriptionReqDto subscriptionReq) {
        return subscriptionService.addSubscription(subscriptionReq);
    }

    @PostMapping("/delete")
    public SubscriptionResDto delete(@RequestBody String email, String list) throws ParseException {
        return subscriptionService.removeSubscription(email, list);
    }

    @PostMapping("/findForEmail")
    public List<SubscriptionResDto> findForEmail(@RequestBody String email) throws ParseException {
        return subscriptionService.getSubscriptionsForEmail(email);
    }
}
