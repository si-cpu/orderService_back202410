package com.spring.orderservice_back202410.product.controller;


import com.spring.orderservice_back202410.common.dto.CommonResDto;
import com.spring.orderservice_back202410.product.dto.ProductResDto;
import com.spring.orderservice_back202410.product.dto.ProductSaveReqDto;
import com.spring.orderservice_back202410.product.entity.Product;
import com.spring.orderservice_back202410.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    // 요청과 함께 이미지가 전달이 될 것이다. 해당 이미지를 처리하는 방식이 두 가지로 나뉜다.
    // 1. JS의 FormData 객체를 통해 모든 데이터를 전달. (multipart/form-data 형식으로 전달, form 태그 x)
    // 2. JSON 형태로 전달 (이미지를 Base64 인코딩을 통해 문자열로 변환해서 전달)
    // ModelAttribute를 사용해서 FormData 객체를 우리가 평소에 사용하는 form 태그 방식으로 받겠다.
    // Model 기능을 쓰겠다는 것은 아닙니다! (React 단에는 model을 전달할 수 없음!)
    public ResponseEntity<?> createProduct(@ModelAttribute ProductSaveReqDto dto) {

        log.info("/product/create: POST");
        Product product = productService.productCreate(dto);

        CommonResDto resDto
                = new CommonResDto(HttpStatus.CREATED, "product 등록 성공", product.getId());

        return new ResponseEntity<>(resDto, HttpStatus.CREATED);
    }


    @GetMapping("/list")
    // 페이징이 필요합니다. 리턴은 ProductResDto 형태로 리턴됩니다.
    // ProductResDto(id, name, category, price, stockQuantity, imagePath)
    public ResponseEntity<?> listProducts(Pageable pageable) {
        log.info("/product/list: GET, pageable={}", pageable);
        List<ProductResDto> dtoList = productService.productList(pageable);

        CommonResDto resDto
                = new CommonResDto(HttpStatus.OK, "상품리스트 정상조회 완료", dtoList);
        return new ResponseEntity<>(resDto, HttpStatus.OK);
    }



}