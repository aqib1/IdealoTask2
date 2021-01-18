package com.idealo.pricing.rules.unit.repositories;

import com.idealo.pricing.rules.repositories.RuleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.skuList;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleRepositoryTest {
    @Mock
    private RuleRepository repository;
    @Test
    public void testDropAll() {
        doNothing().when(repository).dropAll(skuList());

        repository.dropAll(skuList());

        verify(repository, times(1))
                .dropAll(skuList());
    }
}
