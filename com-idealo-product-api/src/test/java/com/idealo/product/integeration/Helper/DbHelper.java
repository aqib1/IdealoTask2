package com.idealo.product.integeration.Helper;

import com.idealo.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.idealo.product.utility.DataHelper.productEntityList;
import static com.idealo.product.utility.DataHelper.productEntityListForDropApi;

@Component
public class DbHelper {

    @Autowired
    private ProductRepository repository;

    public void deleteAll() {
        repository.deleteAll();
    }

    public void initProductEntitiesList() {
        repository.saveAll(productEntityList());
    }

    public void initProductEntitiesListForDropApi() {
        repository.saveAll(productEntityListForDropApi());
    }
}

