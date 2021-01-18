package com.idealo.product.unit.controller;

import com.idealo.product.controller.ProductController;
import com.idealo.product.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static com.idealo.product.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Mock
    private ProductController controller;

    @Test
    public void testAddProduct() {
        when(controller.addProduct(any(AddProductRequest.class)))
                .thenReturn(ResponseEntity.ok(addProductResponse()));

        ResponseEntity<AddProductResponse> response = controller.addProduct(addProductRequest());

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), addProductResponse());
        verify(controller, times(1)).addProduct(addProductRequest());
    }

    @Test
    public void testGetAll() {
        when(controller.getAll()).thenReturn(ResponseEntity.ok(getAllProductResponse()));

        ResponseEntity<GetAllProductResponse> response = controller.getAll();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), getAllProductResponse());
        verify(controller, times(1)).getAll();
    }

    @Test
    public void testGetBySku() {
        when(controller.getAllBySku(any(CheckoutRequest.class))).thenReturn(ResponseEntity.ok(getProductBySkuResponse()));

        ResponseEntity<GetProductBySkuResponse> response = controller.getAllBySku(checkoutRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), getProductBySkuResponse());
        verify(controller, times(1)).getAllBySku(checkoutRequest());
    }

    @Test
    public void testDropAll() {
        when(controller.dropAll(any(DropProductsRequest.class))).thenReturn(ResponseEntity.ok(dropProductsResponse()));

        ResponseEntity<DropProductsResponse> response = controller.dropAll(dropProductsRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), dropProductsResponse());
        verify(controller, times(1)).dropAll(dropProductsRequest());
    }
}
