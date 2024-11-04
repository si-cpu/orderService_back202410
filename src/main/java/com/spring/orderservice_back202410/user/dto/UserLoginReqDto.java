package com.spring.orderservice_back202410.user.dto;


import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginReqDto {

    private String email;
    private String password;

}