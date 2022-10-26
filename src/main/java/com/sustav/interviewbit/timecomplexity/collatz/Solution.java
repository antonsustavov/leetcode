package com.sustav.interviewbit.timecomplexity.collatz;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(5, 6));
    }

    public Long solve(int A, int B) {
        assert(1 <= A && A <= 1e9);
        assert(1 <= B && B <= 1e5);
        if ((A < 1 || A > 1000000000) || (B < 1 || B > 100000)) return -1L;
        long result = A;
        for (int i = 1; i < B; i++) {
            result = result%2 == 0 ? result/2 : 3*result+1;
        }

        return result;
    }
}
