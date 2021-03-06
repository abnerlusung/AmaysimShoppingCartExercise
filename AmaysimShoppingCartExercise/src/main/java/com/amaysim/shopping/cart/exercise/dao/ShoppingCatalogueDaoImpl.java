package com.amaysim.shopping.cart.exercise.dao;

import java.util.HashMap;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.domain.Product;

public class ShoppingCatalogueDaoImpl
    implements ShoppingCatalogueDao {

    private Map<String, Product> catalogue;

    private ShoppingCatalogueDaoImpl() {
        catalogue = new HashMap<String, Product>();
        catalogue.put("ult_small", new Product("ult_small", "Unlimited 1GB", 24.90));
        catalogue.put("ult_medium", new Product("ult_medium", "Unlimited 2GB", 29.90));
        catalogue.put("ult_large", new Product("ult_large", "Unlimited 5GB", 44.90));
        catalogue.put("1gb", new Product("1gb", "1 GB Data-pack", 9.90));
    }

    public Product get(String productCode) {

        return this.catalogue.get(productCode);
    }

    @Override
    public boolean isExist(String itemCode) {

        boolean isValid = false;
        Product product = catalogue.get(itemCode);

        if (product != null) {
            isValid = true;
        }

        return isValid;
    }

}
