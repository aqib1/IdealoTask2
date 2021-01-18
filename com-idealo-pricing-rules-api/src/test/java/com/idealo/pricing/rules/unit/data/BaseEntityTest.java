package com.idealo.pricing.rules.unit.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.idealo.pricing.rules.data.BaseEntity;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

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
