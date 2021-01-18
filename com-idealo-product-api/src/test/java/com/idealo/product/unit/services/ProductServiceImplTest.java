package com.idealo.product.unit.services;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.services.Impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static com.idealo.product.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductServiceImpl service;

    @Test
    public void testSave() {
        when(service.save(any(ProductEntity.class))).thenReturn(productEntity());
        ProductEntity entity = service.save(productEntity());
        assertEquals(entity, productEntity());
        verify(service, times(1)).save(productEntity());
    }

    @Test
    public void testGetAll() {
        when(service.getAll()).thenReturn(productEntityList());
        List<ProductEntity> entityList = service.getAll();
        assertEquals(entityList, productEntityList());
        verify(service, times(1)).getAll();
    }

    @Test
    public void testGetAllBySku() {
        when(service.getAllBySku(anyList())).thenReturn(productEntityList());
        List<ProductEntity> entityList = service.getAllBySku(skuList());
        assertEquals(entityList, productEntityList());
        verify(service, times(1)).getAllBySku(skuList());
    }

    @Test
    public void testDropAll() {
        doNothing().when(service).dropAll(skuList());
        service.dropAll(skuList());
        verify(service, times(1)).dropAll(skuList());
    }
}
