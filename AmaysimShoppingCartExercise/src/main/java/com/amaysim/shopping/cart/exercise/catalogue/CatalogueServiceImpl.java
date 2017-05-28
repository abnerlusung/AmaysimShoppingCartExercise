package com.amaysim.shopping.cart.exercise.catalogue;

import com.amaysim.shopping.cart.exercise.dao.ShoppingCatalogueDaoImpl;
import com.amaysim.shopping.cart.exercise.domain.Product;

public class CatalogueServiceImpl
    implements CatalogueService {

    private ShoppingCatalogueDaoImpl shoppingCatalogue = ShoppingCatalogueDaoImpl.getInstance();

    public Product get(String itemCode) {

        return shoppingCatalogue.get(itemCode);
    }

}
