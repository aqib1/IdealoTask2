package com.idealo.product.unit.mapper;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.mapper.ProductEntityMapper;
import com.idealo.product.model.AddProductRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.product.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductEntityMapperTest {

    @Mock
    private ProductEntityMapper mapper;

    @Test
    public void testToProductEntity() {
        when(mapper.toProductEntity(any(AddProductRequest.class)))
                .thenReturn(productEntity());
        assertEquals(mapper.toProductEntity(addProductRequest()), productEntity());
        verify(mapper, times(1)).toProductEntity(addProductRequest());
    }

    @Test
    public void testToAddProductResponse() {
        when(mapper.toAddProductResponse(any(ProductEntity.class)))
                .thenReturn(addProductResponse());
        assertEquals(mapper.toAddProductResponse(productEntity()), addProductResponse());
        verify(mapper, times(1)).toAddProductResponse(productEntity());
    }

    @Test
    public void testToProductDetailResponse() {
        when(mapper.toProductDetailResponse(any(ProductEntity.class)))
                .thenReturn(productDetailResponse());
        assertEquals(mapper.toProductDetailResponse(productEntity()), productDetailResponse());
        verify(mapper, times(1)).toProductDetailResponse(productEntity());
    }

    @Test
    public void testToProductDetailResponseList() {
        when(mapper.toProductDetailResponseList(anyList()))
                .thenReturn(productDetailResponseList());
        assertEquals(mapper.toProductDetailResponseList(productEntityList()), productDetailResponseList());
        verify(mapper, times(1)).toProductDetailResponseList(productEntityList());
    }

    @Test
    public void testToProductShortResponse() {
        when(mapper.toProductShortResponse(any(ProductEntity.class)))
                .thenReturn(productShortResponse());
        assertEquals(mapper.toProductShortResponse(productEntity()), productShortResponse());
        verify(mapper, times(1)).toProductShortResponse(productEntity());
    }

    @Test
    public void testToProductShortResponseForList() {
        when(mapper.toProductShortResponse(anyList()))
                .thenReturn(productShortResponseList());
        assertEquals(mapper.toProductShortResponse(productEntityList()), productShortResponseList());
        verify(mapper, times(1)).toProductShortResponse(productEntityList());
    }
}
