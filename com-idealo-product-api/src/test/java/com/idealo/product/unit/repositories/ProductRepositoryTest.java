package com.idealo.product.unit.repositories;

import com.idealo.product.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.product.utility.DataHelper.skuList;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductRepositoryTest {

    @Mock
    private ProductRepository repository;
    @Test
    public void testDropAll() {
        doNothing().when(repository).dropAll(skuList());

        repository.dropAll(skuList());

        verify(repository, times(1))
                .dropAll(skuList());
    }
}
