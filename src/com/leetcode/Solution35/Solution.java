package com.leetcode.Solution35;

//  Given a sorted array and a target value, return the index if the target is found.
//  If not, return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the array.
//
//        Example 1:
//
//        Input: [1,3,5,6], 5
//        Output: 2
//        Example 2:
//
//        Input: [1,3,5,6], 2
//        Output: 1
//        Example 3:
//
//        Input: [1,3,5,6], 7
//        Output: 4
//        Example 4:
//
//        Input: [1,3,5,6], 0
//        Output: 0

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[] = {-1,0,3,5,9,12};
        System.out.println(s.searchInsert(testArr, 7));
    }
}

