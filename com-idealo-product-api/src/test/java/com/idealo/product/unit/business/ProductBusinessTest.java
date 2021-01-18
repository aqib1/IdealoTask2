package com.idealo.product.unit.business;

import com.idealo.product.business.ProductBusiness;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.exceptions.StockOutOfBoundException;
import com.idealo.product.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.product.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductBusinessTest {

    @Mock
    private ProductBusiness business;

    @Test
    public void testAddProduct() {
        when(business.addProduct(any(AddProductRequest.class)))
                .thenReturn(addProductResponse());
        AddProductResponse response = business.addProduct(addProductRequest());
        assertEquals(response, addProductResponse());
        verify(business, times(1)).addProduct(addProductRequest());
    }

    @Test
    public void testAddProductForNullRequest() {
        when(business.addProduct(isNull())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            business.addProduct(null);
        });
        verify(business, times(1)).addProduct(null);
    }

    @Test
    public void testAddProductWithInvalidProductRequest() {
        when(business.addProduct(any(AddProductRequest.class))).thenThrow(new InvalidProductException());
        assertThrows(InvalidProductException.class, () -> {
            business.addProduct(invalidAddProductRequest());
        });
        verify(business, times(1)).addProduct(invalidAddProductRequest());
    }

    @Test
    public void testGetAll() {
        when(business.getAll()).thenReturn(getAllProductResponse());
        GetAllProductResponse response = business.getAll();
        assertEquals(response, getAllProductResponse());
        verify(business, times(1)).getAll();
    }

    @Test
    public void testGetAllBySku() {
        when(business.getAllBySku(any(CheckoutRequest.class)))
                .thenReturn(getProductBySkuResponse());
        GetProductBySkuResponse response = business.getAllBySku(checkoutRequest());
        assertEquals(response, getProductBySkuResponse());
        verify(business, times(1)).getAllBySku(checkoutRequest());
    }

    @Test
    public void testGetAllBySkuForOutOfStock() {
        when(business.getAllBySku(any(CheckoutRequest.class)))
                .thenThrow(new StockOutOfBoundException());
        assertThrows(StockOutOfBoundException.class, () -> {
            business.getAllBySku(checkoutRequest());
        });
        verify(business, times(1)).getAllBySku(checkoutRequest());
    }

    @Test
    public void testGetAllBySkuForNullRequest() {
        when(business.getAllBySku(isNull())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            business.getAllBySku(null);
        });
        verify(business, times(1)).getAllBySku(null);
    }

    @Test
    public void testGetAllBySkuForInvalidRequest() {
        when(business.getAllBySku(any(CheckoutRequest.class))).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            business.getAllBySku(invalidCheckoutRequest());
        });
        verify(business, times(1)).getAllBySku(invalidCheckoutRequest());
    }

    @Test
    public void testDropAll() {
        when(business.dropAll(any(DropProductsRequest.class))).thenReturn(dropProductsResponse());
        DropProductsResponse response = business.dropAll(dropProductsRequest());
        assertEquals(response, dropProductsResponse());
        verify(business, times(1)).dropAll(dropProductsRequest());
    }

    @Test
    public void testDropAllForNullRequest() {
        when(business.dropAll(isNull())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            business.dropAll(null);
        });
        verify(business, times(1)).dropAll(null);
    }

    @Test
    public void testDropAllForInvalidRequest() {
        when(business.dropAll(any(DropProductsRequest.class))).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            business.dropAll(invalidDropProductsRequest());
        });
        verify(business, times(1)).dropAll(invalidDropProductsRequest());
    }
}
