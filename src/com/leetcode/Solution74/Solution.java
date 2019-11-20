package com.leetcode.Solution74;


//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//        Example 1:
//
//        Input:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 3
//        Output: true
//        Example 2:
//
//        Input:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 13
//        Output: false

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLeft = 0;
        int rowRight = matrix.length;
        if (rowRight == 0) {
            return false;
        }
        int left = 0;
        int right = matrix[0].length;
        if (right == 0) {
            return false;
        }
        while (rowLeft < rowRight) {
            int mid = rowLeft + (rowRight - rowLeft) / 2;
            if (matrix[mid][0] <= target) rowLeft = mid + 1;
            else rowRight = mid;
        }
        if (rowRight == 0) {
            return false;
        }
        int nums[] = matrix[rowRight - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else right = mid;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[][] = {{1}, {2}, {3}};
        System.out.println(s.searchMatrix(testArr, 4));
    }
}
