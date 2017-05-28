package com.amaysim.shopping.cart.exercise;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amaysim.shopping.cart.exercise.display.DisplayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/ShoppingCartRunnerTest.xml")
public class ShoppingCartRunnerTest {

    @Autowired
    @Qualifier("displayService")
    private DisplayService displayService;

    private ShoppingCartRunner cartRunner;

    @Before
    public void setup() {

        cartRunner = new ShoppingCartRunner();
    }

    @Test
    public void test_addProduct() {

    }

    @Test
    public void test_addProductPromo() {

    }

    @Test
    public void test_total() {

    }

    @Test
    public void test_items() {

    }
}
