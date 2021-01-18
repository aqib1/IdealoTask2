package com.idealo.pricing.rules.integeration.API;

import com.idealo.pricing.rules.integeration.helper.DbHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingRulesApiIT {

    private static final String PRICING_RULE_API = "/pricing/rule";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DbHelper dbHelper;

    @Before
    public void init() {
        dbHelper.deleteAll();
    }

    @Test
    public void testPricingRules() throws Exception {
        dbHelper.initEntitiesInDatabase();

        this.mockMvc.perform(post(PRICING_RULE_API)
                .content(asJsonString(ruleRequestForPricingRules()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ruleInfoResponse.*", hasSize(3)))
                .andExpect(jsonPath("$.total").value(295))
                .andExpect(jsonPath("$.ruleInfoResponse[0].sku").value("AEXC"))
                .andExpect(jsonPath("$.ruleInfoResponse[0].checkoutQuantity").value(5))
                .andExpect(jsonPath("$.ruleInfoResponse[0].shipping").value(5))
                .andExpect(jsonPath("$.ruleInfoResponse[0].specialPrice").value(95))
                .andExpect(jsonPath("$.ruleInfoResponse[0].detailedMessage").value("Product AEXC have offer to buy 4 products get 50 percent discount"))
                .andExpect(jsonPath("$.ruleInfoResponse[1].sku").value("BEXC"))
                .andExpect(jsonPath("$.ruleInfoResponse[2].sku").value("REXC"))
                .andReturn();
    }
}
