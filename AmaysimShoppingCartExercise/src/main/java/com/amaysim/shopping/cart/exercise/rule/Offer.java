package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public interface Offer {

    /**
     * Checks the condition of the offer
     * 
     * @param list
     * @return
     */
    boolean check();

    /**
     * Checks the condition of the offer
     * 
     * @param list
     * @return
     */
    boolean check(Map<String, Integer> list);

    /**
     * Applies the amount changes
     * 
     * @param list
     * @param checklist
     * @return the new amount to be paid for a certain items in the product list
     */
    Double getNewAmount(Map<String, Integer> list, List<ProductChecker> checklist);
}
