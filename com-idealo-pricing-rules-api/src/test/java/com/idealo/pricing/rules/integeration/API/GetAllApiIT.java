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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GetAllApiIT {
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
    public void testGetAllApi() throws Exception {
        dbHelper.initEntitiesInDatabase();

        this.mockMvc.perform(get(PRICING_RULE_GET_ALL_URL)
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ruleInfos.*", hasSize(3)))
                .andExpect(jsonPath("$.ruleInfos[0].sku").value("REXC"))
                .andExpect(jsonPath("$.ruleInfos[0].itemsFromApply").value(3))
                .andExpect(jsonPath("$.ruleInfos[0].discount").value(1))
                .andExpect(jsonPath("$.ruleInfos[0].ruleType").value("BNGN"))
                .andExpect(jsonPath("$.ruleInfos[0].isActive").value(true))
                .andExpect(jsonPath("$.ruleInfos[1].sku").value("AEXC"))
                .andExpect(jsonPath("$.ruleInfos[2].sku").value("BEXC"));
    }
}
