package com.tuilu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/30.
 */
public class MatrixSolution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        /*int n=matrix.length;
        if(n==0)return 0;
        int m=matrix[0].length;
        int count = 0;
        for(int i=0;i<m&&i<n;i++){
            for(int j=i;j<m;j++){
                if(matrix[i][j]==target)count++;
                if(matrix[i][j]>=target)m=j;
            }
            for(int k=i+1;k<n;k++){
                if(matrix[k][i]==target)count++;
                if(matrix[k][i]>=target)n=k;
            }
        }
        return count;*/

        /*int n=matrix.length;
        if(n==0)return 0;
        int m=matrix[0].length;
        int count = 0;
        for(int i=0;i<m&&i<n;i++){
            for(int j=m-1;j>=i;j--){
                if(matrix[i][j]==target)count++;
                if(matrix[i][j]>=target)m=j;
                if(matrix[i][j]<=target)break;
            }
            for(int k=n-1;k>i;k--){
                if(matrix[k][i]==target)count++;
                if(matrix[k][i]>=target)n=k;
                if(matrix[k][i]<=target)break;
            }
        }
        return count;*/

        // 对于排好序的数列，使用二分查找
        int x = 0;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] > target) {
                x = i;
                flag = true;
                break;
            }
        if (!flag)
            x = matrix.length;
        for (int i = 0; i < x; i++) {
            int left = 0;
            int right = matrix[i].length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[i][mid] == target) {
                    sum++;
                    break;
                } else if (matrix[i][mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return sum;
    }

    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return rst;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        while(count * 2 < rows && count * 2 < cols){
            for(int i = count; i < cols-count; i++)
                rst.add(matrix[count][i]);


            for(int i = count+1; i< rows-count; i++)
                rst.add(matrix[i][cols-count-1]);

            if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
                break;

            for(int i = cols-count-2; i>=count; i--)
                rst.add(matrix[rows-count-1][i]);

            for(int i = rows-count-2; i>= count+1; i--)
                rst.add(matrix[i][count]);

            count++;
        }
        return rst;
    }
}
