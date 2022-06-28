package com.bootcampjava.event.model.Project2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
    @Builder.Default
    private Long id= null;
    @Builder.Default
    private Double available= null;
    @Builder.Default
    private Timestamp dateWithdrawal= null;
    @Builder.Default
    private String numberAccount= null;
    @Builder.Default
    private String document= null;
}
