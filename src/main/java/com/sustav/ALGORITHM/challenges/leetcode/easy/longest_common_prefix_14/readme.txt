Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

Approach 1: Horizontal scanning
Intuition

For a start we will describe a simple way of finding the longest prefix shared by a set of strings

Approach 2: Vertical scanning
Algorithm

Imagine a very short string is at the end of the array. The above approach will still do SS comparisons. One way to optimize this case is to do vertical scanning. We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.
Complexity Analysis

Time complexity : O(S)O(S) , where S is the sum of all characters in all strings. In the worst case there will be nn equal strings with length mm and the algorithm performs S = m \cdot nS=m⋅n character comparisons. Even though the worst case is still the same as Approach 1, in the best case there are at most n \cdot minLenn⋅minLen comparisons where minLenminLen is the length of the shortest string in the array.
Space complexity : O(1)O(1). We only used constant extra space.

Approach 3: Divide and conquer

Approach 4: Binary search
The idea is to apply binary search method to find the string with maximum value L, which is common prefix of all of the strings. The algorithm searches space is the interval (0 \ldots minLen)(0…minLen), where minLen is minimum string length and the maximum possible common prefix. Each time search space is divided in two equal parts, one of them is discarded, because it is sure that it doesn't contain the mergeSort. There are two possible cases: