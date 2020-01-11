package rs.raf.service1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.raf.service1.domain.Subscription;
import rs.raf.service1.domain.User;

import java.util.List;

public interface SubscriptionDao extends JpaRepository<Subscription, Long> {

    List<Subscription> findByUser(User user);

    Subscription findByUserAndList(User user, String list);
}
