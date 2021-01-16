package com.idealo.product.mapper;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.model.AddProductRequest;
import com.idealo.product.model.AddProductResponse;
import com.idealo.product.model.ProductDetailResponse;
import com.idealo.product.model.ProductShortResponse;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <p>
 * This is the class for idealo product entity mapper
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntity toProductEntity(AddProductRequest request);

    AddProductResponse toAddProductResponse(ProductEntity entity);

    ProductDetailResponse toProductDetailResponse(ProductEntity entity);

    List<ProductDetailResponse> toProductDetailResponseList(List<ProductEntity> entities);

    ProductShortResponse toProductShortResponse(ProductEntity entity);

    List<ProductShortResponse> toProductShortResponse(List<ProductEntity> entities);
}
