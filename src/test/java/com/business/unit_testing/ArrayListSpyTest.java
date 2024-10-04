package com.business.unit_testing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ArrayListSpyTest {
    @Test
    public void mocking() {

        ArrayList arrayListMock = mock(ArrayList.class);
        arrayListMock.add("Test0");
        System.out.println(arrayListMock.get(0)); // ops:- null , as the above add wouldn't have worked as it is a mocked class and don't get the original behaviour
        System.out.println(arrayListMock.size()); // ops:- 0, as the elements will not be added into mock
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // ops:- 0
        // till here the arrayListSpy.size() retained its original behaviour, from now we mock the function and so it behaves like a mock
        when(arrayListMock.size()).thenReturn(100);
        System.out.println(arrayListMock.size()); // ops:- 100
        arrayListMock.add("Test3");
        arrayListMock.add("Test4");
        // now when called size(), still it returns the mocked response
        System.out.println(arrayListMock.size()); // ops:- 100
        verify(arrayListMock).add("Test3"); // test fails as Test38 is never added using add function

    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size()); // ops:- 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // ops:- 3
        // till here the arrayListSpy.size() retained its original behaviour, from now we mock the function and so it behaves like a mock
        when(arrayListSpy.size()).thenReturn(100);
        System.out.println(arrayListSpy.size()); // ops:- 100
        arrayListSpy.add("Test3");
        arrayListSpy.add("Test4");
        // now when called size(), still it returns the mocked response
        System.out.println(arrayListSpy.size()); // ops:- 100
        verify(arrayListSpy).add("Test38"); // test fails as Test38 is never added using add function
    }
}
