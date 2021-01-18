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
import static org.hamcrest.Matchers.hasSize;
import static com.idealo.product.utility.DataHelper.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GetAllProductApiIT {
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
    public void testGetAll() throws Exception {
        dbHelper.initProductEntitiesList();
        this.mockMvc.perform(get(PRODUCT_GET_ALL)
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productDetailResponseList.*",hasSize(1)))
                .andExpect(jsonPath("$.productDetailResponseList[0].sku").value("REXC"))
                .andExpect(jsonPath("$.productDetailResponseList[0].productId").value("REX-A"))
                .andExpect(jsonPath("$.productDetailResponseList[0].productName").value("Olive oil"))
                .andExpect(jsonPath("$.productDetailResponseList[0].madeIn").value("Germany"))
                .andExpect(jsonPath("$.productDetailResponseList[0].brand").value("REMBH"))
                .andExpect(jsonPath("$.productDetailResponseList[0].unitPrice").value(3))
                .andExpect(jsonPath("$.productDetailResponseList[0].shipping").value(5))
                .andExpect(jsonPath("$.productDetailResponseList[0].quantity").value(10))
                .andExpect(jsonPath("$.productDetailResponseList[0].supplierName").value("John"))
                .andExpect(jsonPath("$.productDetailResponseList[0].isActive").value(true));
    }
}
