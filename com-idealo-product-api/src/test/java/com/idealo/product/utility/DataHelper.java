package com.idealo.product.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.product.entities.ProductEntity;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.exceptions.StockOutOfBoundException;
import com.idealo.product.model.*;
import org.assertj.core.util.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class DataHelper {

    public static final WebRequest TEST_WEB_REQUEST = null;
    public static final RuntimeException TEST_RUNTIME_EXC = new RuntimeException();
    public static MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json");

    public static ResponseEntity<ResponseError> getHandleStockOutOfBoundException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(StockOutOfBoundException.class.getName()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(StockOutOfBoundException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseError> getHandleInvalidRequestException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(InvalidRequestException.class.getName()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(InvalidRequestException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseError> handleInvalidProductException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(InvalidProductException.class.getName()).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(InvalidProductException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseError> getHandlerRuntimeException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(IllegalStateException.class.getName()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(IllegalStateException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static DropProductsRequest invalidDropProductsRequest() {
        return new DropProductsRequest();
    }

    public static DropProductsRequest dropProductsRequest() {
        return new DropProductsRequest().skuList(
          Lists.newArrayList("REXC")
        );
    }

    public static DropProductsResponse dropProductsResponse() {
        return new DropProductsResponse().detailMessage("REXC product dropped");
    }

    public static CheckoutRequest invalidCheckoutRequest() {
        return new CheckoutRequest();
    }

    public static CheckoutRequest checkoutRequest() {
        return new CheckoutRequest().checkoutInfo(
          Lists.newArrayList(checkoutInfo())
        );
    }
    public static GetProductBySkuResponse getProductBySkuResponse() {
        return new GetProductBySkuResponse().productShortResponseList(
                Lists.newArrayList(productShortResponse())
        );
    }

    public static GetAllProductResponse getAllProductResponse() {
        return new GetAllProductResponse().productDetailResponseList(
                Lists.newArrayList(productDetailResponse())
        );
    }

    public static List<ProductDetailResponse> productDetailResponseList() {
        return Lists.newArrayList(productDetailResponse());
    }

    public static List<ProductEntity> productEntityList() {
        return Lists.newArrayList(productEntity());
    }

    public static List<ProductEntity> productEntityListForDropApi() {
        return Lists.newArrayList(
                new ProductEntity(1l, "OOXC", "REX-B", "Olive oil", "Germany", "AEMBH", 3l, 10l, 5l, "John", true)
        );
    }

    public static DropProductsRequest dropProductsRequestForDropApi() {
        return new DropProductsRequest().skuList(
                Lists.newArrayList("OOXC")
        );
    }

    public static ProductEntity productEntity() {
        return new ProductEntity(1l, "REXC", "REX-A", "Olive oil", "Germany", "REMBH", 3l, 10l, 5l, "John", true);
    }

    public static List<CheckoutInfo> checkoutInfoList() {
        return Lists.newArrayList(checkoutInfo());
    }

    public static CheckoutInfo checkoutInfo() {
        return new CheckoutInfo()
                .checkoutQuantity(1l)
                .sku("REXC");
    }

    public static List<ProductShortResponse> productShortResponseList() {
        return Lists.newArrayList(productShortResponse());
    }

    public static ProductShortResponse productShortResponse() {
        return new ProductShortResponse()
                .productId("REX-A")
                .sku("REXC")
                .shipping(5l)
                .quantity(10l)
                .unitPrice(3l)
                .detailedMessage("");
    }
    public static ProductDetailResponse productDetailResponse() {
        return new ProductDetailResponse()
                .productId("REX-A")
                .productName("Olive oil")
                .isActive(true)
                .brand("REMBH")
                .quantity(10l)
                .supplierName("John")
                .unitPrice(3l)
                .madeIn("Germany")
                .sku("REXC")
                .shipping(5l);
    }

    public static AddProductRequest invalidAddProductRequest() {
        return new AddProductRequest();
    }

    public static AddProductRequest addProductRequest() {
        return new AddProductRequest()
                .sku("REXC")
                .productId("REX-A")
                .productName("Olive oil")
                .brand("REMBH")
                .isActive(true)
                .madeIn("Germany")
                .unitPrice(20L)
                .quantity(40l)
                .supplierName("John");
    }

    public static AddProductResponse addProductResponse() {
        return new AddProductResponse()
                .productId("REX-A")
                .productName("Olive oil")
                .sku("REXC")
                .detailMessage("Product save successfully");
    }

    public static List<String> skuList() {
        return Lists.newArrayList("REXC");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialization on demand pattern
     * this pattern is alternative of double check locking pattern
     * which not even support lazy loading but also safe to use in
     * multi-processor distributed instances
     */

    private static class InstanceHolder {
        private static final DataHelper INSTANCE = new DataHelper();

        private InstanceHolder() {

        }
    }


    public static DataHelper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private DataHelper() {

    }
}
