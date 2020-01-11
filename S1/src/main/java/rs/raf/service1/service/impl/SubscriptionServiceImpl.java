package rs.raf.service1.service.impl;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import rs.raf.service1.dao.SubscriptionDao;
import rs.raf.service1.dao.UserDao;
import rs.raf.service1.domain.Frequency;
import rs.raf.service1.domain.Subscription;
import rs.raf.service1.domain.User;
import rs.raf.service1.domain.dto.SubscriptionReqDto;
import rs.raf.service1.domain.dto.SubscriptionResDto;
import rs.raf.service1.domain.dto.UserResDto;
import rs.raf.service1.service.SubscriptionService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionDao subscriptionDao;
    private final UserDao userDao;

    @Override
    public List<SubscriptionResDto> findAll() {
        List<SubscriptionResDto> subscriptionDtos = new ArrayList<>();
        for(Subscription s : subscriptionDao.findAll())
            subscriptionDtos.add(new SubscriptionResDto(s));
        return subscriptionDtos;
    }

    @Override
    public SubscriptionResDto addSubscription(SubscriptionReqDto subscriptionDto) {
        Subscription subscription = Subscription.builder().list(subscriptionDto.getList())
                .frequency(Frequency.valueOf(subscriptionDto.getFrequency())).user(userDao.findByEmail(subscriptionDto.getEmail()).get()).build();
        subscriptionDao.save(subscription);
        return new SubscriptionResDto(subscription);
    }

    @Override
    public SubscriptionResDto removeSubscription(String userEmail, String list) throws ParseException {
//        JSONParser parser = new JSONParser();
//        JSONObject jobj = (JSONObject) parser.parse(userEmail);
//        String email = (String) jobj.get("userEmail");
//        String sublist = (String) jobj.get("list");
//        User user = userDao.findByEmail(email).get();
        User user = userDao.findByEmail(userEmail).get();
        Subscription subscription = subscriptionDao.findByUserAndList(user, list);
        if(subscription==null) System.out.println("sub");
        subscriptionDao.deleteById(subscription.getId());
        return new SubscriptionResDto(subscription);
    }

    @Override
    public List<SubscriptionResDto> getSubscriptionsForEmail(String userEmail) throws ParseException {
//        JSONParser parser = new JSONParser();
//        JSONObject jobj = (JSONObject) parser.parse(userEmail);
//        String email = (String) jobj.get("userEmail");
//        User user = userDao.findByEmail(email).get();
        System.out.println(userEmail);
        User user = userDao.findByEmail(userEmail).get();
        List<Subscription> subscriptions = subscriptionDao.findByUser(user);
        ArrayList<SubscriptionResDto> subscriptionResDtos = new ArrayList<>();
        for(Subscription sub : subscriptions)
            subscriptionResDtos.add(new SubscriptionResDto(sub));
        return subscriptionResDtos;
    }

}
