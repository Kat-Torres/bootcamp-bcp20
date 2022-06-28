package com.bootcampjava.event.model.Project2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AfpModel {
    @Builder.Default
    private Long id= null;
    @Builder.Default
    private String description= null;
}
