package com.business.unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {
    @Test
    public void test1_mock_basicSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        // programmatically creating a mock class with a function call that returns a mock data
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.getNums()).thenReturn(new int[]{1,2,3});
        business.setSomeDataServiceImpl(dataServiceMock);

        int expectedValue = 6;
        int actualResponse = business.calculateSumUsingDataService();
        assertEquals(actualResponse, expectedValue);
    }

    @Test
    public void test2_mock_emptyArraySum() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.getNums()).thenReturn(new int[0]);
        business.setSomeDataServiceImpl(dataServiceMock);

        int expectedValue = 0;
        int actualResponse = business.calculateSumUsingDataService();
        assertEquals(actualResponse, expectedValue);
    }
}
