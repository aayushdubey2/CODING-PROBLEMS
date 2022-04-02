package com.problems.solutions.array;

import java.util.Arrays;

public class Sort012s {
    //T: O(N*logN) S:O(1)
    public static void sort012Sol1(int[] arr) {
        Arrays.sort(arr);
    }
    //T: O(N)+O(N) = O(N) S: O(1)
    public static void sort012Sol2(int[] arr) {
        //Count sort
        //get frequency of each, and then change that many elements one by one
        int[] counts = {0, 0, 0};
        int i = 0, j = 0, k = 0;
        for (i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        for (i = 0; i < counts[0]; i++) {
            arr[i] = 0;
        }
        for (j = i; j < counts[1] + i; j++) {
            arr[j] = 1;
        }
        for (k = j; k < counts[2] + j; k++) {
            arr[k] = 2;
        }
    }
    //T: O(N) S: O(1)
    public static void sort012Sol3(int[] arr) {
        // Dutch national flag algorithm
        int low = 0, mid = 0;
        int high = arr.length - 1;
        int temp = 0;
        while (mid <= high) {
            // case 0:
            if (arr[mid] == 0) {
                temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            }

            // case 1:
            else if (arr[mid] == 1) {
                mid++;
            }

            // case 2:
            else if (arr[mid] == 2) {
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
