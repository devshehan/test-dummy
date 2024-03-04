package com.shehan.productservice.service;

import com.shehan.productservice.dto.ProductRequest;
import com.shehan.productservice.dto.ProductResponse;
import com.shehan.productservice.mapper.ProductMapper;
import com.shehan.productservice.model.Product;
import com.shehan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public void createProduct(ProductRequest productRequest){

        // map productRequest to Product
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        // save into the database
        productRepository.save(product);
        log.info("product : id:{} saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){

        // get products from the database
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(productMapper::mapProductToProductResponse)
                .collect(Collectors.toList());
    }
}
