package com.business.unit_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // in junit5, in junit4 we need to use @RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest_2 {

    @InjectMocks // automatically the setter method is called with the mock
    SomeBusinessImpl business = new SomeBusinessImpl();
    // programmatically creating a mock class with a function call that returns a mock data
    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void test1_mock_basicSum() {

        when(dataServiceMock.getNums()).thenReturn(new int[]{1,2,3});
        // multiple returns i.e when called 1st time 1st return value and called 2nd time 2nd return value should be returned
        // when(dataServiceMock.getNums()).thenReturn(new int[]{1,2,3}).thenReturn(new int[]{10,11,12});

        int expectedValue = 6;
        int actualResponse = business.calculateSumUsingDataService();
        assertEquals(actualResponse, expectedValue); // 1st call gives 1st return
    }

    @Test
    public void test2_mock_emptyArraySum() {

        when(dataServiceMock.getNums()).thenReturn(new int[0]); // we can also return a string or any primitive type
        int expectedValue = 0;
        int actualResponse = business.calculateSumUsingDataService();
        assertEquals(actualResponse, expectedValue);
    }
}
