package com.amaysim.shopping.cart.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * Users entry point for the Shopping Cart
 */
public class ShoppingCartRunner {

    private CartService cartService;

    public CartService getCart() {

        return cartService;
    }

    @Autowired
    public void setCart(CartService cart) {

        this.cartService = cart;
        this.cartService.reset();
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});
        CartServiceImpl cartService = (CartServiceImpl) context.getBean("cartService");
        ShoppingCartRunner shoppingCartRunner1 = new ShoppingCartRunner();
        shoppingCartRunner1.setCart(cartService);
        shoppingCartRunner1.add("ult_small");
        shoppingCartRunner1.add("ult_small");
        shoppingCartRunner1.add("ult_small");
        shoppingCartRunner1.add("ult_large");
        shoppingCartRunner1.total();
        shoppingCartRunner1.items();

        ShoppingCartRunner shoppingCartRunner2 = new ShoppingCartRunner();
        shoppingCartRunner2.setCart(cartService);
        shoppingCartRunner2.add("ult_small");
        shoppingCartRunner2.add("ult_small");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.total();
        shoppingCartRunner2.items();

        ShoppingCartRunner shoppingCartRunner3 = new ShoppingCartRunner();
        shoppingCartRunner3.setCart(cartService);
        shoppingCartRunner3.add("ult_small");
        shoppingCartRunner3.add("ult_medium");
        shoppingCartRunner3.add("ult_medium");
        shoppingCartRunner3.total();
        shoppingCartRunner3.items();

        ShoppingCartRunner shoppingCartRunner4 = new ShoppingCartRunner();
        shoppingCartRunner4.setCart(cartService);
        shoppingCartRunner4.add("ult_small");
        shoppingCartRunner4.add("1gb", "I<3AMAYSIM");
        shoppingCartRunner4.total();
        shoppingCartRunner4.items();
    }

    public void add(String productCode) {

        getCart().addProduct(productCode);

    }

    public void add(String productCode, String promoCode) {

        getCart().addProduct(productCode);
        getCart().addPromoCode(promoCode);
    }

    public void total() {

        System.out.println("======================");
        System.out.println(getCart().getTotalAmount());
    }

    public void items() {

        System.out.println(getCart().getDisplay());
        System.out.println("======================");
    }
}
