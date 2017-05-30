package com.amaysim.shopping.cart.exercise.catalogue;

import org.springframework.beans.factory.annotation.Autowired;

import com.amaysim.shopping.cart.exercise.dao.ShoppingCatalogueDao;
import com.amaysim.shopping.cart.exercise.domain.Product;

public class CatalogueServiceImpl
    implements CatalogueService {

    private ShoppingCatalogueDao shoppingCatalogue;

    public CatalogueServiceImpl(ShoppingCatalogueDao shoppingCatalogue) {
        super();
        this.shoppingCatalogue = shoppingCatalogue;
    }

    public ShoppingCatalogueDao getShoppingCatalogue() {

        return shoppingCatalogue;
    }

    @Autowired
    public void setShoppingCatalogue(ShoppingCatalogueDao shoppingCatalogue) {

        this.shoppingCatalogue = shoppingCatalogue;
    }

    public Product get(String itemCode) {

        return getShoppingCatalogue().get(itemCode);
    }

}
