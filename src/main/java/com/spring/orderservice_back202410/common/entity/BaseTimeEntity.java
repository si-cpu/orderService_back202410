package com.spring.orderservice_back202410.common.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;
}
