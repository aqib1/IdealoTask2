package com.idealo.product.utility;

import com.idealo.product.utils.AppUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.idealo.product.utility.DataHelper.checkoutInfoList;
import static com.idealo.product.utility.DataHelper.productShortResponseList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUtilsTest {

    @Test
    public void testSkuByQuantity() {
        Map<String, Long> skuByQuantity = AppUtils.skuByQuantity(productShortResponseList());
        assertEquals(skuByQuantity.get("REXC"), 10l);
    }

    @Test
    public void testSkuByQuantityForCheckout() {
        Map<String, Long> skuByQuantity = AppUtils.skuByQuantityForCheckout(checkoutInfoList());
        assertEquals(skuByQuantity.get("REXC"), 1l);
    }
}
