package com.business.unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// Right click and Run/Debug this test class
public class SomeBusinessTest {
    @Test
    public void test1_basicSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int[] nums = {1,2,3};
        int expectedValue = 6;
        int actualResponse = business.calculateSum(nums);
        assertEquals(actualResponse, expectedValue);
    }

    @Test
    public void test2_emptyArraySum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int[] nums = {};
        int expectedValue = 0;
        int actualResponse = business.calculateSum(nums);
        assertEquals(actualResponse, expectedValue);
    }
}
