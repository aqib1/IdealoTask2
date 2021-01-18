package com.idealo.discovery.server;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IdealoDiscoveryServerTest {

    @Test
    public void contextLoads() throws NoSuchMethodException, SecurityException {
        Class<?> c = IdealoDiscoveryServer.class;
        String methodName = "main";
        Method method = c.getDeclaredMethod(methodName, String[].class);
        assertNotNull(method);
    }
}
