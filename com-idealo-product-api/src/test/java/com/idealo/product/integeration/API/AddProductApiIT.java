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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AddProductApiIT {
    private static final String PRODUCT_ADD = "/product/add";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DbHelper dbHelper;

    @Before
    public void init() {
        dbHelper.deleteAll();
    }

    @Test
    public void testAddProductApi() throws Exception {
        this.mockMvc.perform(post(PRODUCT_ADD)
                .content(asJsonString(addProductRequest()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sku").value("REXC"))
                .andExpect(jsonPath("$.productId").value("REX-A"))
                .andExpect(jsonPath("$.productName").value("Olive oil"))
                .andExpect(jsonPath("$.detailMessage").value("Product save successfully"));
    }
}
