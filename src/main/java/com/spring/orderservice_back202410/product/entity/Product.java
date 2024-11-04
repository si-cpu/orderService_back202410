package com.spring.orderservice_back202410.product.entity;


import com.spring.orderservice_back202410.common.entity.BaseTimeEntity;
import com.spring.orderservice_back202410.product.dto.ProductResDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Integer price;
    private Integer stockQuantity;
    private String imagePath;

    // 이미지 경로 setter 직접 작성
    public void updateImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public ProductResDto fromEntity() {
        return ProductResDto.builder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .stockQuantity(stockQuantity)
                .imagePath(imagePath)
                .build();
    }


}