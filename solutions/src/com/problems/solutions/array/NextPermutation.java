package com.problems.solutions.array;
import java.util.ArrayList;

// Time: O(N)
// Space: O(1)

//Algorithm:
//1. Find the last value (arr[i]) in arr which is smaller than it's right next element (arr[i+1])
//2. Find the value which is greater than the above mentioned element, in range( i+1 , arr.length )
//3. swap these values
//4. reverse values from i+1 to arr.length

public class NextPermutation {
    public static void reverse(ArrayList<Integer> permutation, int i, int j) {
        while(i < j) swap(permutation, i++, j--);
    }
    public static void swap(ArrayList<Integer> permutation, int i, int j) {
        int temp = permutation.get(i);
        permutation.set(i,permutation.get(j));
        permutation.set(j,temp);
    }
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation)
    {
        int i =0,start=-1;
        int len = permutation.size();
        int end=len-1;

        // if len <=1, return same
        if(len<=1){
            return permutation;
        }

        // find the last element in arr, which is smaller than next element
        for(i=len-2;i>=0;i--){
            if(permutation.get(i)<permutation.get(i+1)){
                start=i;
                break;
            }
        }

        // if no such element, i.e arr in desc order, reverse arr ,
        // special case, as this is the last possible permutation,
        // next permutation in this case will be the starting case
        if(start == -1){
            reverse(permutation,start+1,len-1);
            return permutation;
        }
        else{
            // find val to be replaced from end
            for(i=len-1;i>start;i--){
                if(permutation.get(i)>permutation.get(start)){
                    end=i;
                    break;
                }
            }
        }
        swap(permutation,start,end);
        reverse(permutation,start+1,len-1);
        return permutation;
    }
}
