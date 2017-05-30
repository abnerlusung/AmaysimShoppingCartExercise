package com.amaysim.shopping.cart.exercise.rule;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/rule/RuleOneTest.xml")
public class RuleOneTest {

    @Autowired
    private CatalogueService catalogueService;

    private Offer rule;

    @Before
    public void setup() {

        EasyMock.reset(catalogueService);
        rule = new RuleOne(catalogueService);
    }

    @Test
    public void test_check() {

    }

    @Test
    public void test_getNewAmount() {

    }
}
