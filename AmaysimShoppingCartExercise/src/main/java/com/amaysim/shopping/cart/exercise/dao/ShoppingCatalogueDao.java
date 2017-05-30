package com.amaysim.shopping.cart.exercise.dao;

import com.amaysim.shopping.cart.exercise.domain.Product;

public interface ShoppingCatalogueDao {

    /**
     * 
     * @param productCode
     * @return
     */
    Product get(String productCode);

    boolean isExist(String itemCode);
}
