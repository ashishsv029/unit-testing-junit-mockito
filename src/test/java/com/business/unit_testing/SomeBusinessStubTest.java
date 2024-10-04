package com.business.unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class someDataServiceStub implements SomeDataService {

    @Override
    public int[] getNums() {
        return new int[]{1,2,3};
    }
}

class someDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] getNums() {
        return new int[0];
    }
}

public class SomeBusinessStubTest {
    @Test
    public void test1_stub_basicSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataServiceImpl(new someDataServiceStub()); // method injection
        int expectedValue = 6;
        int actualResponse = business.calculateSumUsingDataService();
        assertEquals(actualResponse, expectedValue);
    }

    @Test
    public void test2_stub_emptyArraySum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataServiceImpl(new someDataServiceEmptyStub()); // method injection
        int expectedValue = 0;
        int actualResponse = business.calculateSumUsingDataService();
        assertEquals(actualResponse, expectedValue);
    }
}
