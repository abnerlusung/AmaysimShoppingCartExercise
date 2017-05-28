package com.amaysim.shopping.cart.exercise.dao;

import com.amaysim.shopping.cart.exercise.domain.Product;

public interface ShoppingCatalogueDao {

    Product get(String productCode);
}
