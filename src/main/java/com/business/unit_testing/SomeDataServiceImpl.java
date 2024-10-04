package com.business.unit_testing;

public class SomeDataServiceImpl implements SomeDataService{

    @Override
    public int[] getNums() {
        // fetch from db / any logic to generate the array
        return new int[0]; // empty array
    }
}
