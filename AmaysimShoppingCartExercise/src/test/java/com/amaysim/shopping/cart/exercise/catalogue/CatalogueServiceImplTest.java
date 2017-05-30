package com.amaysim.shopping.cart.exercise.catalogue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amaysim.shopping.cart.exercise.dao.ShoppingCatalogueDao;
import com.amaysim.shopping.cart.exercise.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/catalogue/CatalogueServiceImplTest.xml")
public class CatalogueServiceImplTest {

    @Autowired
    private ShoppingCatalogueDao shoppingCatalogue;

    private CatalogueService catalogueService;

    @Before
    public void setup() {

        EasyMock.reset(shoppingCatalogue);
        catalogueService = new CatalogueServiceImpl(shoppingCatalogue);
    }

    @Test
    public void test_get() {

        Product mockProduct = new Product("ult_small", "Dummy Name", 123.75);
        EasyMock.expect(shoppingCatalogue.get("ult_small"))
            .andReturn(mockProduct);
        EasyMock.replay(shoppingCatalogue);
        Product product = catalogueService.get("ult_small");
        assertNotNull(product);
        assertEquals(product.getCode(), "ult_small");
        assertEquals(product.getName(), "Dummy Name");
        assertEquals(String.valueOf(product.getPrice()), String.valueOf(123.75));
        EasyMock.verify(shoppingCatalogue);
    }
}
