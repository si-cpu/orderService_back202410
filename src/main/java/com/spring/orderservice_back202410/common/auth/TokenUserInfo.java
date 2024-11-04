package com.spring.orderservice_back202410.common.auth;


import com.spring.orderservice_back202410.user.entity.Role;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenUserInfo {

    private String email;
    private Role role;

}