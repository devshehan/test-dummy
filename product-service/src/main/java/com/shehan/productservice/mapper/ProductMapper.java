package com.shehan.productservice.mapper;

import com.shehan.productservice.dto.ProductResponse;
import com.shehan.productservice.model.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
    @Mapping(target = "productId" , source = "id")
    @Mapping(target = "productName", source = "name")
    ProductResponse mapProductToProductResponse(Product product);
}
