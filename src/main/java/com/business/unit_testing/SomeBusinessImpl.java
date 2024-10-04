package com.business.unit_testing;

public class SomeBusinessImpl {
    private SomeDataService someDataServiceImpl;

    public void setSomeDataServiceImpl(SomeDataService someDataServiceImpl) {
        this.someDataServiceImpl = someDataServiceImpl;
    }

    public int calculateSum(int nums[]) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public int calculateSumUsingDataService() {

        int[] nums = someDataServiceImpl.getNums();
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;

    }
}
