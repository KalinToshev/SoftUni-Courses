package shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsTest {
    private Goods goods;

    @Before
    public void setUp() {
        goods = new Goods("Bananas", "1010101010");
    }

    @Test
    public void getName() {
        Assert.assertTrue(goods.getName().equals("Bananas"));
    }

    @Test
    public void getGoodsCode() {
        Assert.assertEquals("1010101010", goods.getGoodsCode());
    }
}