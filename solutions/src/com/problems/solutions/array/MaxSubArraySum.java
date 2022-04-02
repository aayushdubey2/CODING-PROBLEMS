package com.problems.solutions.array;

//Kadane's Algorithm
//time: O(N)
//space: O(1)

public class MaxSubArraySum {
    public static long maxSubarraySum(int[] arr, int n) {
        long globalsum = arr[0], localsum=arr[0];
        for(int i=1;i<n;i++){
            localsum= Math.max(arr[i],arr[i]+localsum);
            globalsum = Math.max(localsum,globalsum);
        }
        return globalsum;
    }
}
