package com.bootcampjava.event.model.Project2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {
    @Builder.Default
    private Long id= null;
    @Builder.Default
    private Double amount= null;
    @Builder.Default
    private String document= null;
    @Builder.Default
    private String nameafp= null;
}
