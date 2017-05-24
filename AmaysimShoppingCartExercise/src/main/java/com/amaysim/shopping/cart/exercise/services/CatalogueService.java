package com.amaysim.shopping.cart.exercise.services;

import com.amaysim.shopping.cart.exercise.domain.Product;

public interface CatalogueService {

    Product get(String itemCode);
}
