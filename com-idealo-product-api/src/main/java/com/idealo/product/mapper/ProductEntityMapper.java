package com.idealo.product.mapper;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.model.AddProductResponse;
import com.idealo.product.model.ProductRequest;
import org.mapstruct.Mapper;

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
    ProductEntity productEntityFromProductRequest(ProductRequest request);

    AddProductResponse addProductResponseFromProductEntity(ProductEntity entity);

}
