package com.idealo.checkout.integeration.API;


import com.idealo.checkout.business.CheckoutBusiness;
import com.idealo.checkout.clients.ProductClient;
import com.idealo.checkout.clients.RuleInfoClient;
import com.idealo.checkout.controller.CheckoutController;
import com.idealo.checkout.controller.advice.ExceptionsAdvice;
import com.idealo.checkout.exception.InvalidRequestException;
import com.idealo.checkout.mappers.RuleInfoMapper;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleRequest;
import com.idealo.checkout.service.Impl.CheckoutServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.idealo.checkout.integeration.helper.DataHelperIT.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class CheckoutApiIT {

    private static final String CHECKOUT_CHECK = "/checkout/check";

    private MockMvc mockMvc;

    @Mock
    private ProductClient productClient;

    @Mock
    private RuleInfoClient ruleInfoClient;

    @Spy
    private RuleInfoMapper mapper;

    @Spy
    @InjectMocks
    private CheckoutServiceImpl service;

    @Spy
    @InjectMocks
    private CheckoutBusiness business;

    @Spy
    @InjectMocks
    private CheckoutController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ExceptionsAdvice()).build();
    }

    @Test
    public void testCheckout() throws Exception {
        when(productClient.getAllBySku(any(CheckoutRequest.class)))
                .thenReturn(getProductBySkuResponse());

        when(ruleInfoClient.pricingRules(any(RuleRequest.class)))
                .thenReturn(ruleResponse());

        this.mockMvc.perform(post(CHECKOUT_CHECK)
                .content(asJsonString(checkoutRequest()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(300))
                .andExpect(jsonPath("$.ruleInfoResponse[0].sku").value("SKU"))
                .andExpect(jsonPath("$.ruleInfoResponse[0].checkoutQuantity").value(6))
                .andExpect(jsonPath("$.ruleInfoResponse[0].shipping").value(5))
                .andExpect(jsonPath("$.ruleInfoResponse[0].specialPrice").value(300))
                .andExpect(jsonPath("$.ruleInfoResponse[0].detailedMessage").value("Free shipping for buying 5 items"));

    }

    @Test
    public void testCheckoutForInvalidRequest() throws Exception {
        this.mockMvc.perform(post(CHECKOUT_CHECK)
                .content(asJsonString(invalidCheckoutRequest()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.exceptionName").value("com.idealo.checkout.exception.InvalidRequestException"))
        ;
    }
}
