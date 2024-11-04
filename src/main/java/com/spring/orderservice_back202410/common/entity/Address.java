package com.spring.orderservice_back202410.common.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable // 타 엔터티에서 사용가능한 형태로 만드는 어노테이션
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Builder
public class Address {
    private String city;
    private String street;
    private String zipCode; // 연산하지 않을 것임.
}
