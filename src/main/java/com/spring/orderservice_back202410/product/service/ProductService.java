package com.spring.orderservice_back202410.product.service;

import com.spring.orderservice_back202410.product.dto.ProductResDto;
import com.spring.orderservice_back202410.product.dto.ProductSaveReqDto;
import com.spring.orderservice_back202410.product.entity.Product;
import com.spring.orderservice_back202410.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product productCreate(ProductSaveReqDto dto) {

        MultipartFile productImage = dto.getProductImage();

        String uniqueFileName
                = UUID.randomUUID() + "_" + productImage.getOriginalFilename();

        File file
                = new File("/Users/stephen/Desktop/develop/upload/" + uniqueFileName);
        try {
            productImage.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 실패!");
        }

        Product product = dto.toEntity();
        product.updateImagePath(uniqueFileName);

        return productRepository.save(product);

    }

    public List<ProductResDto> productList(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        List<Product> content = products.getContent();
        List<ProductResDto> dtoList = content.stream()
                .map(product -> product.fromEntity())
                .collect(Collectors.toList());

        return dtoList;
    }
}