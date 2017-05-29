package com.amaysim.shopping.cart.exercise;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/ShoppingCartRunnerTest.xml")
public class ShoppingCartRunnerTest {

    @Autowired
    @Qualifier("cart")
    private CartService cart;

    private ShoppingCartRunner cartRunner;

    @Before
    public void setup() {

        EasyMock.reset(cart);
        cartRunner = new ShoppingCartRunner();

    }

    @Test
    public void test_addProduct() {

        cart.reset();
        EasyMock.expectLastCall();
        cart.addProduct("ult_small");
        EasyMock.expectLastCall();

        EasyMock.replay(cart);

        cartRunner.setCart(cart);
        cartRunner.add("ult_small");

        EasyMock.verify(cart);
    }

    @Test
    public void test_addProductPromo() {

        cart.reset();
        EasyMock.expectLastCall();

        cart.addProduct("ult_small");
        EasyMock.expectLastCall();

        cart.addPromoCode("I<3AMAYSIM");
        EasyMock.expectLastCall();

        EasyMock.replay(cart);

        cartRunner.setCart(cart);
        cartRunner.add("ult_small", "I<3AMAYSIM");

        EasyMock.verify(cart);
    }

    @Test
    public void test_total() {

        cart.reset();
        EasyMock.expectLastCall();
        EasyMock.expect(cart.getTotalAmount())
            .andReturn("Dummy total amount.");

        EasyMock.replay(cart);

        cartRunner.setCart(cart);
        cartRunner.total();

        EasyMock.verify(cart);
    }

    @Test
    public void test_items() {

        cart.reset();
        EasyMock.expectLastCall();
        EasyMock.expect(cart.getDisplay())
            .andReturn("Dummy display list");
        EasyMock.replay(cart);

        cartRunner.setCart(cart);
        cartRunner.items();

        EasyMock.verify(cart);
    }
}
