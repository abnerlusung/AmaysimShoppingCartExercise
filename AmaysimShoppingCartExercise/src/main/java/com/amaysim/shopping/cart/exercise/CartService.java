package com.amaysim.shopping.cart.exercise;

public interface CartService {

    void addProduct(String itemCode);

    String getDisplay();

    String getTotalAmount();

    void addPromoCode(String promoCode);

    void reset();
}
