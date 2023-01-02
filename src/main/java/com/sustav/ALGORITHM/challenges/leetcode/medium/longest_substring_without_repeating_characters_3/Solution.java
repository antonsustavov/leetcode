package com.sustav.ALGORITHM.challenges.leetcode.medium.longest_substring_without_repeating_characters_3;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Anton Sustavov
 * @since 2020/09/13
 */
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
//        solution.lengthOfLongestSubstring3("dvdf");
        solution.lengthOfLongestSubstring3("abcabcbb");
    }
    public int lengthOfLongestSubstring(String s) {
        BitSet bits1 = new BitSet(127);
        int result = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!bits1.get(s.charAt(i))) {
                bits1.set(s.charAt(i));
                result++;
            } else {
                prev = Math.max(prev, result);
                bits1.clear();
                result = 0;
                bits1.set(s.charAt(i));
                result++;
            }
        }
        return Math.max(prev, result);
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        final Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
