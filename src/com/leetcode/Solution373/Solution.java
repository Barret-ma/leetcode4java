package com.leetcode.Solution373;



//You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
//        Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
//        Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
//        Example 1:
//
//        Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//        Output: [[1,2],[1,4],[1,6]]
//        Explanation: The first 3 pairs are returned from the sequence:
//        [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//        Example 2:
//
//        Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//        Output: [1,1],[1,1]
//        Explanation: The first 2 pairs are returned from the sequence:
//        [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//        Example 3:
//
//        Input: nums1 = [1,2], nums2 = [3], k = 3
//        Output: [1,3],[2,3]
//        Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> b[0] + b[1] - a[0] - a[1]);
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k==0) return res;
        for (int i = 0; i < nums1.length && i < k; i++)
            que.offer(new int[]{ nums1[i], nums2[0], 0 });
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
//        for (int i = 0; i < Math.min(nums1.length, k); i ++) {
//            for (int j = 0; j < Math.min(nums2.length, k); j ++) {
//                if (que.size() < k) {
//                    que.offer(new int[]{nums1[i], nums2[j]});
//                }
//                else if (nums1[i] + nums2[j] < que.peek()[0] + que.peek()[1]) {
//                    que.offer(new int[]{nums1[i], nums2[j]});
//                    que.poll();
//                }
//            }
//        }
//        while (!que.isEmpty()) {
//            int arr[] = que.peek();
//            res.add(Arrays.asList(arr[0], arr[1]));
//            que.poll();
//        }
//        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr1[] = {-10,-4,0,0,6};
        int testArr2[] = {3,5,6,7,8,100};
        s.kSmallestPairs(testArr1, testArr2, 10);
//        s.kSmallestPairs(testArr1, testArr2, 3);
    }
}
