package com.practice.Ewallet.Transaction;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransactionRequest {
    private String fromUser;
    private Double amount;
    private String toUser;
    private String purpose;
}
