package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Goods goodsOne;
    private Goods goodsTwo;
    private Goods goodsThree;
    private Shop shop;

    @Before
    public void setUp() {
        goodsOne = new Goods("Bananas", "1010101010");
        goodsTwo = new Goods("Tomatoes", "12345678901");
        goodsThree = new Goods("Cucumbers", "1112223335");
        shop = new Shop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shelfDoesNotExist() throws OperationNotSupportedException {
        shop.addGoods("NqmaTakuv", goodsOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shelfIsAlreadyTaken() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goodsOne);
        shop.addGoods("Shelves1", goodsThree);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void goodsAlreadyExistInTheShelfs() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goodsOne);
        shop.addGoods("Shelves3", goodsOne);
    }

    @Test
    public void goodsIsAddedSuccessfullyInTheShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goodsOne);
        Assert.assertTrue(shop.getShelves().get("Shelves1") != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shelfDoesNotExistExceptionInRemoveMethod() {
        shop.removeGoods("Nevaliden", goodsOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void goodsInTheGivenShelvesDoesNotExistExceptionInRemoveMethod() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goodsOne);
        shop.removeGoods("Shelves1", goodsThree);
    }

    @Test
    public void goodsIsSuccessfullyRemoved() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goodsOne);
        shop.removeGoods("Shelves1", goodsOne);
        Assert.assertTrue(shop.getShelves().get("Shelves1") == null);
    }
}