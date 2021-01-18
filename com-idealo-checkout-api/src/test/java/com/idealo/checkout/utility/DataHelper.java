package com.idealo.checkout.utility;

import com.google.common.collect.Lists;
import com.idealo.checkout.clients.ProductClient;
import com.idealo.checkout.clients.RuleInfoClient;
import com.idealo.checkout.exception.BadRequestException;
import com.idealo.checkout.exception.InternalServiceException;
import com.idealo.checkout.exception.InvalidRequestException;
import com.idealo.checkout.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class DataHelper {


    public static final WebRequest TEST_WEB_REQUEST = null;
    public static final RuntimeException TEST_RUNTIME_EXC = new RuntimeException();

    public static ResponseEntity<ResponseError> getHandlerRuntimeException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(IllegalStateException.class.getName()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(IllegalStateException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseError> getHandleInvalidRequestException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(InvalidRequestException.class.getName()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(InvalidRequestException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseError> getHandleBadRequestException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(BadRequestException.class.getName()).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(BadRequestException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseError> getHandleInternalServiceException() {
        return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
                .detailedMessage(InternalServiceException.class.getName()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(InternalServiceException.class.getName()).errorMessage("Error - Message"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static List<ProductShortResponse> productShortResponseList() {
        return org.assertj.core.util.Lists.newArrayList(productShortResponse());
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

    public static ProductClient productClient() {
        return new ProductClient() {
            @Override
            public GetProductBySkuResponse getAllBySku(CheckoutRequest request) {
                return null;
            }
        };
    }

    public static RuleInfoClient ruleInfoClient() {
        return new RuleInfoClient() {
            @Override
            public RuleResponse pricingRules(RuleRequest request) {
                return null;
            }
        };
    }

    public static RuleRequest ruleRequest() {
        return new RuleRequest().ruleInfoRequest(getRuleInfoRequestList());
    }

    public static RuleResponse ruleResponse() {
        return new RuleResponse().ruleInfoResponse(ruleInfoResponseList());
    }

    public static List<RuleInfoResponse> ruleInfoResponseList() {
        return Lists.newArrayList(ruleInfoResponse());
    }

    public static RuleInfoResponse ruleInfoResponse() {
        return new RuleInfoResponse()
                .checkoutQuantity(1l)
                .sku("ERAC")
                .shipping(0L)
                .unitPrice(5L)
                .specialPrice(5l);
    }

    public static List<RuleInfoRequest> getRuleInfoRequestList() {
        return Lists.newArrayList(ruleInfoRequest());
    }

    public static RuleInfoRequest ruleInfoRequest() {
        return new RuleInfoRequest()
                .checkoutQuantity(1l)
                .sku("ERAC")
                .shipping(0l)
                .unitPrice(5l);
    }

    public static GetProductBySkuResponse getProductBySkuResponse() {
        return new GetProductBySkuResponse()
                .productShortResponseList(productShortResponseList());
    }

    public static CheckoutRequest checkoutRequest() {
        return new CheckoutRequest().checkoutInfo(checkoutInfoList());
    }

    public static CheckoutRequest checkoutRequestInvalid() {
        return new CheckoutRequest();
    }

    public static List<CheckoutInfo> checkoutInfoList() {
        return Lists.newArrayList(checkoutInfo());
    }

    public static CheckoutInfo checkoutInfo() {
        return new CheckoutInfo()
                .checkoutQuantity(1l)
                .sku("ERAC");
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
