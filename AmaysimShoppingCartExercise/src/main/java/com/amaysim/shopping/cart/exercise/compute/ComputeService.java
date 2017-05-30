package com.amaysim.shopping.cart.exercise.compute;

import java.util.Map;

public interface ComputeService {

    /**
     * Computes the total amount to be paid
     * 
     * @param list
     * @return
     */
    double getTotalAmount(Map<String, Integer> list);

}
