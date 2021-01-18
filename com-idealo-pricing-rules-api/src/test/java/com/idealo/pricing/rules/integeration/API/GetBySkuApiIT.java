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
public class GetBySkuApiIT {

    private static final String PRICING_RULE_GET_ALL_URL = "/pricing/all";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DbHelper dbHelper;

    @Before
    public void init() {
        dbHelper.deleteAll();
    }

    @Test
    public void testGetBySku() throws Exception {
        dbHelper.initEntitiesInDatabase();

        this.mockMvc.perform(post(PRICING_RULE_GET_ALL_URL)
                .content(asJsonString(getRulesBySkuRequestForGetBySku()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ruleInfos.*", hasSize(2)))
                .andExpect(jsonPath("$.ruleInfos[1].sku").value("REXC"))
                .andExpect(jsonPath("$.ruleInfos[1].itemsFromApply").value(3))
                .andExpect(jsonPath("$.ruleInfos[1].discount").value(1))
                .andExpect(jsonPath("$.ruleInfos[1].ruleType").value("BNGN"))
                .andExpect(jsonPath("$.ruleInfos[1].isActive").value(true))
                .andExpect(jsonPath("$.ruleInfos[0].sku").value("AEXC"));
    }

    @Test
    public void testGetBySkuForInvalidRequest() throws Exception {
        this.mockMvc.perform(post(PRICING_RULE_GET_ALL_URL)
                .content(asJsonString(getRulesBySkuRequestForGetBySkuInvalid()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.exceptionName").value("com.idealo.pricing.rules.exceptions.InvalidRequestException"));
    }
}
