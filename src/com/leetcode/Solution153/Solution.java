package com.leetcode.Solution153;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
//        Find the minimum element.
//
//        You may assume no duplicate exists in the array.
//
//        Example 1:
//
//        Input: [3,4,5,1,2]
//        Output: 1
//        Example 2:
//
//        Input: [4,5,6,7,0,1,2]
//        Output: 0

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[] = {3,4,5,1,2};
        System.out.println(s.findMin(testArr));
    }
}
