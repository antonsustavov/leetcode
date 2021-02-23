package com.sustav.leetcode.easy.longest_common_prefix_14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anton Sustavov
 * @since 2020/09/15
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix7(new String[]{"flower","flow","flight"}));
//        System.out.println(solution.longestCommonPrefix(new String[]{"a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length < 2) return strs[0];
        final StringBuilder result = new StringBuilder();
        Arrays.parallelSort(strs, Comparator.comparingInt(String::length));
        String smallest = strs[0];
        for (int i = 0; i < smallest.length(); i++) {
            final char c = smallest.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
        }

        return result.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length < 2) return strs[0];
        final StringBuilder result = new StringBuilder();
        String smallest = strs[0];
        for (int i = 0; i < smallest.length(); i++) {
            final char c = smallest.charAt(i);
            for (int j = 1; j < strs.length; j++) {
//                if (strs[j].length()-1 < i || c != strs[j].charAt(i)) {
                if (i == strs[j].length()|| c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
        }

        return result.toString();
    }

//    Approach 1: Horizontal scanning
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

//    Approach 2: Vertical scanning
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

//    Approach 3: Divide and conquer
    public String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix6(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix6(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix6(strs, l , mid);
            String lcpRight =  longestCommonPrefix6(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

//    Approach 4: Binary search
    public String longestCommonPrefix7(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }


//    public String longestCommonPrefix8(String q, String[] strs) {
//        if (strs == null || strs.length == 0)
//            return "";
//        if (strs.length == 1)
//            return strs[0];
//        Trie trie = new Trie();
//        for (int i = 1; i < strs.length ; i++) {
//            trie.insert(strs[i]);
//        }
//        return trie.searchLongestPrefix(q);
//    }
}

//class TrieNode {
//
//    // R links to node children
//    private TrieNode[] links;
//    private final int R = 26;
//    private boolean isEnd;
//    // number of children non null links
//    private int size;
//
//    public void put(char ch, TrieNode node) {
//        links[ch -'a'] = node;
//        size++;
//    }
//
//    public int getLinks() {
//        return size;
//    }
//    //assume methods containsKey, isEnd, get, put are implemented as it is described
//    //in  https://leetcode.com/articles/implement-trie-prefix-tree/)
//}

//class Trie {
//
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//    //assume methods insert, search, searchPrefix are implemented as it is described
////in  https://leetcode.com/articles/implement-trie-prefix-tree/)
//    public String searchLongestPrefix(String word) {
//        TrieNode node = root;
//        StringBuilder prefix = new StringBuilder();
//        for (int i = 0; i < word.length(); i++) {
//            char curLetter = word.charAt(i);
//            if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
//                prefix.append(curLetter);
//                node = node.get(curLetter);
//            }
//            else
//                return prefix.toString();
//
//        }
//        return prefix.toString();
//    }
//
//}
