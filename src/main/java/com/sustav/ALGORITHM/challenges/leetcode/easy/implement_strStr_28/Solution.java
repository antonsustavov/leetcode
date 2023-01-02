package com.sustav.ALGORITHM.challenges.leetcode.easy.implement_strStr_28;

/**
 * @author Anton Sustavov
 * @since 2020/09/22
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
//        System.out.println(solution.strStr("aaaaa", "bba"));
//        System.out.println(solution.strStr("hello", "ll"));
//        System.out.println(solution.strStr("mississippi", "issip"));
//        System.out.println(solution.strStr("aaa", "a"));
        System.out.println(solution.strStr2("mississippi", "pi"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;
        int needleLength = needle.length();
        if (needleLength == 0) return 0;
        if (needleLength > haystack.length()) return -1;
        int ptr = -1;
        char firstLetter = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == firstLetter && i+needleLength <= haystack.length()) {
                ptr = i;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(++i) != needle.charAt(j)) {
                        i = ptr;
                        ptr = -1;
                        break;
                    }
                }
                if (ptr != -1) {
                    return ptr;
                }
            }
        }

        return ptr;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int valueCount = haystack.length();
        int strCount = needle.length();
        char first = needle.charAt(0);
        int max = (valueCount - strCount);
        for (int i = 0; i <= max; i++) {
            // Look for first character.
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }
            // Found first character, now look at the rest of value
            if (i <= max) {
                int j = i + 1;
                int end = j + strCount - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        if(haystack.length()==0 || haystack.length()<needle.length())
            return -1;
        int i,j,k;
        boolean flag=true;
        for(i=0;i<(haystack.length()-needle.length()+1);i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                flag=true;
                for(j=i,k=0;k<needle.length();j++,k++){
                    if(haystack.charAt(j)!=needle.charAt(k)){
                        flag=false;
                        break;
                    }
                    else
                        continue;
                }
                if(flag)
                    return i;
            }
        }
        return -1;
    }

    public int strStr4(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i,i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
