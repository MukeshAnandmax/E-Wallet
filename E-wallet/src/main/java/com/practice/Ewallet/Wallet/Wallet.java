package com.practice.Ewallet.Wallet;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internalId")
    Long id;
    String userId;
    Double balance;

    public Wallet(String userId, double balance) {
        this.balance =balance;
        this.userId =userId;
    }
}
