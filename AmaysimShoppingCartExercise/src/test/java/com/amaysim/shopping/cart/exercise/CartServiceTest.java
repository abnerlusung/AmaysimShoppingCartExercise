package com.amaysim.shopping.cart.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueService;
import com.amaysim.shopping.cart.exercise.compute.ComputeService;
import com.amaysim.shopping.cart.exercise.display.DisplayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/CartServiceTest.xml")
public class CartServiceTest {

    @Autowired
    @Qualifier("computeService")
    private ComputeService computeService;

    @Autowired
    @Qualifier("displayService")
    private DisplayService displayService;

    @Autowired
    @Qualifier("catalogueService")
    private CatalogueService catalogueService;

    private CartService cart;

    @Before
    public void setup() {

        EasyMock.reset(computeService, displayService, catalogueService);
        cart = new CartServiceImpl(computeService, displayService, catalogueService);

    }

    @Test
    public void test_addProduct() {

        cart.addProduct("ult_small");
    }

    @Test
    public void test_addPromoCode() {

        cart.addProduct("I<3AMAYSIM");
    }

    @Test
    public void test_getDisplay() {

        EasyMock.expect(displayService.print(EasyMock.anyObject()))
            .andReturn("1 x Unlimited 1GB");
        EasyMock.replay(displayService);

        String displayList = cart.getDisplay();

        assertNotNull(displayList);
        assertEquals(displayList, "1 x Unlimited 1GB");
        EasyMock.verify(displayService);
    }

    @Test
    public void test_getTotalAmount() {

        EasyMock.expect(computeService.getTotalAmount(EasyMock.anyObject()))
            .andReturn(0.0);
        EasyMock.replay(computeService);

        String amount = cart.getTotalAmount();
        assertNotNull(amount);
        assertEquals(amount, "0");

        EasyMock.verify(computeService);
    }

    @Test
    public void test_reset() {

        cart.reset();
    }

}
