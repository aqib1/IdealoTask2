package com.idealo.pricing.rules.unit;

import com.idealo.pricing.rules.RuleApplication;
import com.idealo.pricing.rules.data.BaseEntity;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RuleApplicationTest {

    @Test
    public void contextLoads() throws NoSuchMethodException, SecurityException {
        Class<?> c = RuleApplication.class;
        String methodName = "main";
        Method method = c.getDeclaredMethod(methodName, String[].class);
        assertNotNull(method);
    }
}
