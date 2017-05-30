package com.amaysim.shopping.cart.exercise.catalogue;

import com.amaysim.shopping.cart.exercise.domain.Product;

public interface CatalogueService {

    /**
     * Gets the product from the memory
     * 
     * @param itemCode
     * @return
     */
    Product get(String itemCode);

    /**
     * Validates item code
     * 
     * @param itemCode
     * @return
     */
    boolean isExist(String itemCode);
}
