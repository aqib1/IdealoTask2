package com.idealo.pricing.rules.converters;

import com.idealo.pricing.rules.data.RuleTypes;
import com.idealo.pricing.rules.exceptions.InvalidRuleTypeException;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter
public class RuleTypeConverter implements AttributeConverter<RuleTypes, String> {
    @Override
    public String convertToDatabaseColumn(RuleTypes attribute) {
        if (Objects.isNull(attribute))
            return null;
        return attribute.getTag();
    }

    @Override
    public RuleTypes convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData))
            return null;
        return Stream.of(RuleTypes.values())
                .filter(rule -> rule.getTag().equals(dbData))
                .findFirst()
                .orElseThrow(InvalidRuleTypeException::new);
    }
}
