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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DropAllApiIT {
    private static final String PRICING_RULE_DROP_ALL_URL = "/pricing/drop";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DbHelper dbHelper;

    @Before
    public void init() {
        dbHelper.deleteAll();
    }

    @Test
    public void dropAllTest() throws Exception {
        dbHelper.initEntitiesForDropApi();
        this.mockMvc.perform(post(PRICING_RULE_DROP_ALL_URL)
                .content(asJsonString(dropRulesRequestForDropAll()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void testDropAllForInvalidRequest() throws Exception {
        this.mockMvc.perform(post(PRICING_RULE_DROP_ALL_URL)
                .content(asJsonString(dropRulesRequestForDropAllInvalid()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.exceptionName").value("com.idealo.pricing.rules.exceptions.InvalidRequestException"));
    }
}
