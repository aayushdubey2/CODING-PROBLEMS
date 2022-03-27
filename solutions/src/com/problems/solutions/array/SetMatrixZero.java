package com.problems.solutions.array;
import java.util.Arrays;

// Solution 1:
// Time Complexity:O((N*M)*(N + M)) = O(N^3)
// O(N*M) for traversing through each element and (N+M) for traversing to row and column of elements having value 0.
// Space Complexity:O(1)

// Solution 2:
// Time Complexity: O(N*M + N*M) = O(N^2)
// Space Complexity: O(N)

// Solution 3:
// Time Complexity: O(2*(N*M)) = O(N^2), as we are traversing two times in a matrix,
// Space Complexity: O(1).


public class SetMatrixZero {
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i =0,j=0,k=0;

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(matrix[i][j]==0){

                    // change row
                    for(k=0;k<n;k++){
                        if(matrix[i][k]!=0){
                            matrix[i][k]=2284;
                        }
                    }

                    // change column
                    for(k=0;k<m;k++){
                        if(matrix[k][j]!=0){
                            matrix[k][j]=2284;
                        }
                    }
                }

            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(matrix[i][j]==2284){
                    matrix[i][j]=0;
                }
            }
        }

    }
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i =0,j=0;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        Arrays.fill(arr1,-1);
        Arrays.fill(arr2,-1);
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(matrix[i][j]==0){
                    arr1[j]=0;
                    arr2[i]=0;
                }
            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(arr1[j]==0 || arr2[i]==0){
                    matrix[i][j]=0;
                }
            }
        }


    }
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i =0,j=0;

        // flag for the (0,0) value
        int colZero = 1;
        for ( i=0; i<m ; i++){
            // (0,0) is responsible for row and col, can't change value directly.
            if( matrix[i][0]==0)
                colZero=0;
            for(j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for ( i=m-1; i>=0 ; i--){
            for(j=n-1;j>0;j--){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
            if (colZero==0){
                matrix[i][0]=0;
            }
        }
    }
}
