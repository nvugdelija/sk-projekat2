package rs.raf.service1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "subscription", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "list"}))
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String list;

    private Frequency frequency;

}
