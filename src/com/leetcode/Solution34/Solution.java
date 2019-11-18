package com.leetcode.Solution34;

//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int result[] = {-1, -1};
        int left = 0;
        int right = nums.length;
        if (right == 0) {
            return result;
        }
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
            return result;
        }
        result[0] = right;
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        result[1] = right - 1;
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[] = {5, 7, 7, 8, 8, 10};
        System.out.println(s.searchRange(testArr, 8));
    }
}
