package com.bootcampjava.event.model.Project2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeModel {
    @Builder.Default
    private Long id= null;
    @Builder.Default
    private String name= null;
    @Builder.Default
    private String surname= null;
    @Builder.Default
    private String phone= null;
    @Builder.Default
    private String email= null;
    @Builder.Default
    private String nameafp= null;
    @Builder.Default
    private String document= null;

}
