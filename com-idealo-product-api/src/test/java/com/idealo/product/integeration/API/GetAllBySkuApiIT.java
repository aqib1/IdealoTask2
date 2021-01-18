package com.idealo.product.integeration.API;

import com.idealo.product.integeration.Helper.DbHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.idealo.product.utility.DataHelper.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GetAllBySkuApiIT {
    private static final String PRODUCT_GET_ALL = "/product/all";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DbHelper dbHelper;

    @Before
    public void init() {
        dbHelper.deleteAll();
    }

    @Test
    public void testGetAllBySku() throws Exception {
        dbHelper.initProductEntitiesList();
        this.mockMvc.perform(post(PRODUCT_GET_ALL)
                .content(asJsonString(checkoutRequest()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productShortResponseList.*",hasSize(1)))
                .andExpect(jsonPath("$.productShortResponseList[0].sku").value("REXC"))
                .andExpect(jsonPath("$.productShortResponseList[0].productId").value("REX-A"))
                .andExpect(jsonPath("$.productShortResponseList[0].quantity").value(10))
                .andExpect(jsonPath("$.productShortResponseList[0].unitPrice").value(3))
                .andExpect(jsonPath("$.productShortResponseList[0].shipping").value(5));
    }
}
