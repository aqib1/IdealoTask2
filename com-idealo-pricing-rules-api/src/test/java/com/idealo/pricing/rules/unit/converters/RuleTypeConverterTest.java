package com.idealo.pricing.rules.unit.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.idealo.pricing.rules.converters.RuleTypeConverter;
import com.idealo.pricing.rules.data.RuleTypes;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleTypeConverterTest {

    @Mock
    private RuleTypeConverter converter;

    @Test
    public void convertToDatabaseColumnTest() {
        when(converter.convertToDatabaseColumn(RuleTypes.BNGN)).thenReturn("BN");
        assertEquals(converter.convertToDatabaseColumn(RuleTypes.BNGN), "BN");
        verify(converter, times(1)).convertToDatabaseColumn(RuleTypes.BNGN);
    }

    @Test
    public void convertToEntityAttributeTest() {
        when(converter.convertToEntityAttribute("BN")).thenReturn(RuleTypes.BNGN);
        assertEquals(converter.convertToEntityAttribute("BN"), RuleTypes.BNGN);
        verify(converter, times(1)).convertToEntityAttribute("BN");
    }

}
