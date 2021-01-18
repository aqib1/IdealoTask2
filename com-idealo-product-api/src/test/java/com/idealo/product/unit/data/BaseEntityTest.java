package com.idealo.product.unit.data;

import com.idealo.product.data.BaseEntity;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseEntityTest {

    @Test
    public void contextLoads() throws NoSuchMethodException, SecurityException {
        Class<?> c = BaseEntity.class;
        String methodName = "hashCode";
        Method method = c.getDeclaredMethod(methodName);
        assertNotNull(method);

        methodName = "equals";
        method = c.getDeclaredMethod(methodName, Object.class);
        assertNotNull(method);

        methodName = "toString";
        method = c.getDeclaredMethod(methodName);
        assertNotNull(method);
    }
}
