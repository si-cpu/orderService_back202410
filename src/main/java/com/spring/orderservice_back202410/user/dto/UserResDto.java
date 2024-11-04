package com.spring.orderservice_back202410.user.dto;

import com.spring.orderservice_back202410.common.entity.Address;
import com.spring.orderservice_back202410.user.entity.Role;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResDto {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private Address address;



}