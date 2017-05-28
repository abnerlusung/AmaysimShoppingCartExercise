package com.amaysim.shopping.cart.exercise.display;

import java.util.List;

import com.amaysim.shopping.cart.exercise.domain.Product;

public interface DisplayService {

    /**
     * 
     * @param list
     */
    String print(List<Product> list);
}
