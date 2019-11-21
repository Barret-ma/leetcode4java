package com.leetcode.Solution719;

import java.util.Arrays;

//Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
//
//        Example 1:
//        Input:
//        nums = [1,3,1]
//        k = 1
//        Output: 0
//        Explanation:
//        Here are all the pairs:
//        (1,3) -> 2
//        (1,1) -> 0
//        (3,1) -> 2
//        Then the 1st smallest distance pair is (1,1), and its distance is 0.
//        Note:
//        2 <= len(nums) <= 10000.
//        0 <= nums[i] < 1000000.
//        1 <= k <= len(nums) * (len(nums) - 1) / 2.

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0, start = 0;
            for (int i = 0; i < n; i ++) {
                while (start < n && nums[i] - nums[start] > mid) start ++;
                cnt += i - start;
            }
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[] = {1,3,1};
        System.out.println(s.smallestDistancePair(testArr, 1));
    }
}
