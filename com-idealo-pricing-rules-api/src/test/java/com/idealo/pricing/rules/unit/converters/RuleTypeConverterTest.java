package com.idealo.pricing.rules.unit.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.idealo.pricing.rules.converters.RuleTypeConverter;
import com.idealo.pricing.rules.data.RuleTypes;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RuleTypeConverterTest {

    @Mock
    private RuleTypeConverter converter;

    @Test
    public void convertToDatabaseColumnTest() {
        when(converter.convertToDatabaseColumn(RuleTypes.BNGN)).thenReturn("BN");
        assertEquals(converter.convertToDatabaseColumn(RuleTypes.BNGN), "BN");
    }

    @Test
    public void convertToEntityAttributeTest() {
        when(converter.convertToEntityAttribute("BN")).thenReturn(RuleTypes.BNGN);
        assertEquals(converter.convertToEntityAttribute("BN"), RuleTypes.BNGN);
    }

}
