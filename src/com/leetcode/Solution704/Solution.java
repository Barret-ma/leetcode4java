package com.leetcode.Solution704;

//Given a sorted (in ascending order) integer array nums
// of n elements and a target value, write a function to
// search target in nums. If target exists, then return its index,
// otherwise return -1.


//Example 1:
//
//        Input: nums = [-1,0,3,5,9,12], target = 9
//        Output: 4
//        Explanation: 9 exists in nums and its index is 4
//
//        Example 2:
//
//        Input: nums = [-1,0,3,5,9,12], target = 2
//        Output: -1
//        Explanation: 2 does not exist in nums so return -1

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (right == nums.length || nums[right] != target) {
            return -1;
        }
        return right;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[] = {-1,0,3,5,9,12};
        System.out.println(s.search(testArr, 2));
    }
}

