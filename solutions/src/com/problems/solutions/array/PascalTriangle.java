package com.problems.solutions.array;

// Solution:
// When you see the image above, you get a pretty good idea of what you are supposed to do here.
// Think about the image as a matrix now where each line is basically a row in the matrix.
// So, first things first, if you are at the edge of the matrix, the value is 1, that’s for sure.
// Now, what about the inner elements? Well, any inner element is obtained by doing the sum of the
// 2 values present in the row just above it, i.e., if the element is at index (i, j), then matrix[i][j]
// can be obtained by doing matrix[i – 1][j – 1] + matrix[i – 1][j].

//Time Complexity: We are creating a 2D array of size (numRows * numCols) (where 1 <= numCols <= numRows), and we are traversing through each of the cells to update it with its correct value, so Time Complexity = O(numRows2).
//Space Complexity: Since we are creating a 2D array, space complexity = O(numRows2).

public class PascalTriangle {
    public static void drawTriangle(int n){

        // a 2D matrix to store the result
        // 2 1D matrix to store current and prev row
        // check for boundry conditions
        // else, value = prev[j-1]+prev[j]

        int[][] matrix = new int[n][];
        int[] curr, prev = null;

        for(int i =1 ;i<=n;i++){
            curr = new int[i];
            for(int j = 1;j<=i;j++){
                if(j==1 || j==i){
                    curr[j-1]=1;
                }
                else{
                    // subtracting extra 1 because i have taken indexing from 1
                    curr[j-1]=prev[j-1]+prev[j-1-1];
                }
            }
            prev = curr;
            matrix[i-1]=curr;
        }
    }
}
