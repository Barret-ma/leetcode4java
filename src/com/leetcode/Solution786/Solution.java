package com.leetcode.Solution786;


//A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.
//
//        What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.
//
//        Examples:
//        Input: A = [1, 2, 3, 5], K = 3
//        Output: [2, 5]
//        Explanation:
//        The fractions to be considered in sorted order are:
//        1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
//        The third fraction is 2/5.
//
//        Input: A = [1, 7], K = 1
//        Output: [1, 7]
//        Note:
//
//        A will have length between 2 and 2000.
//        Each A[i] will be between 1 and 30000.
//        K will be between 1 and A.length * (A.length - 1) / 2.

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        float left = 0;
        float right = 1;
        int n = A.length;
        int result[] = {0,1};
        while (left < right) {
            float mid = left + (right - left) / 2;
            int cnt = 0;
            result[0] = 0;
            for (int i = 0; i < n - 1; i ++) {
                int fra = i + 1;

                while (fra < n) {
                    if(((float)A[i] / A[fra]) < mid) {
                        cnt ++;
                        if (result[0] * A[fra] < result[1] * A[i]) {
                            result[0] = A[i];
                            result[1] = A[fra];
                        }

                    }
                    fra ++;
                }
            }
            if(cnt == K) {
                return result;
            }
            if (cnt < K) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int testArr[] = {1, 2, 3, 5};
        s.kthSmallestPrimeFraction(testArr, 5);
    }
}
