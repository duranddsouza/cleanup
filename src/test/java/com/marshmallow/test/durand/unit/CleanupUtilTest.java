package com.marshmallow.test.durand.unit;

import com.marshmallow.test.durand.model.Coordinates;
import com.marshmallow.test.durand.util.CleanupUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CleanupUtilTest {

    @Test
    public void test_navigation() {
        Coordinates position = new Coordinates(0,2);

        position = CleanupUtil.getNextPosition(position, 'N');
        Assert.assertTrue(position.equals(new Coordinates(0,3)));

        position = CleanupUtil.getNextPosition(position, 'E');
        Assert.assertTrue(position.equals(new Coordinates(1,3)));

        position = CleanupUtil.getNextPosition(position, 'S');
        Assert.assertTrue(position.equals(new Coordinates(1,2)));

        position = CleanupUtil.getNextPosition(position, 'W');
        Assert.assertTrue(position.equals(new Coordinates(0,2)));
    }

    @Test
    public void test_insideArea_One() {
        Coordinates area = new Coordinates(5,5);
        Coordinates position = new Coordinates(1,2);
        Assert.assertTrue(CleanupUtil.isPositionInsideArea(area, position));
    }

    @Test
    public void test_insideArea_Two() {
        Coordinates area = new Coordinates(5,5);
        Coordinates position = new Coordinates(5,5);
        Assert.assertTrue(CleanupUtil.isPositionInsideArea(area, position));
    }

    @Test
    public void test_outsideArea_One() {
        Coordinates area = new Coordinates(1,1);
        Coordinates position = new Coordinates(1,2);
        Assert.assertFalse(CleanupUtil.isPositionInsideArea(area, position));
    }
}
