# java
1. SegmentedTree --> given an array, you need to find the sum of a given segment. ex: array has 17 elements, indexed 0 to 16. You need to find the sum of segment from index 4 to 11.
We can do it using for loop. But that takes O(nq) to find sum, where n is number of elements in input array , q is number of queries client does. To update a value at a given index,
it takes O(1). With segmented tree, the construction is O(n) and updates can be handled in O(logn)

2. Count triplets : find three nos which form geometric progression with given r and a. ex: 1,3,9,9,27,81 .The GPs are 1-3-9, 1-3-9, 3-9-27,, 3-9-27, 9-27-81, 9-27-81. total 6. Yes duplicates included.

NOTES :
Balanced binary search tree : If number of elements at leaf is n , and height is h, then 2^h >= n .
If the height is h , then number of elements the tree will have is 2^(h+1) - 1 .
If we combine these two, suppose u have n1 elements. You want to put all of them as leaf nodes and construct a tree. Then the tree will have total nodes = 2^(logn+1) - 1 .
Log is on base 2


* PrintNumsUsingRecursion.java : basic program to show how you can print numbers using recursion instead of 'for' loop. Also has method for factorial.
