package com.amaysim.shopping.cart.exercise.services;

import com.amaysim.shopping.cart.exercise.domain.Product;
import com.amaysim.shopping.cart.exercise.storage.ShoppingCatalogue;

public class CatalogueServiceImpl
    implements CatalogueService {

    private ShoppingCatalogue shoppingCatalogue = ShoppingCatalogue.getInstance();

    public Product get(String itemCode) {

        return shoppingCatalogue.get(itemCode);
    }

}
