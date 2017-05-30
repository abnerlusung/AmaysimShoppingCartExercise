package com.amaysim.shopping.cart.exercise.display;

import java.util.Map;

public interface DisplayService {

    /**
     * Creates the display list of products purchased
     * 
     * @param list
     */
    String print(Map<String, Integer> list);

    String print(Map<String, Integer> purchasedItems, Map<String, Integer> freeItems);
}
