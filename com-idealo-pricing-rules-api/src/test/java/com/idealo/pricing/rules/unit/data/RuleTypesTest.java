package com.idealo.pricing.rules.unit.data;

import com.idealo.pricing.rules.data.RuleTypes;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class RuleTypesTest {

    @Test
    public void testGetterSetter() {
        PojoClass pojoClass = PojoClassFactory.getPojoClass(RuleTypes.class);
        Validator validator = ValidatorBuilder.create().with(new GetterMustExistRule())
                .with(new GetterTester()).build();
        validator.validate(pojoClass);
    }

    @Test
    public void testGetDetails() {
        RuleTypes ruleType = RuleTypes.BNGN;
        assertEquals(ruleType.getDetails("AXCV", 1l, 1l), "Product AXCV have offer to buy 1 products get 1 products free");
    }
}
