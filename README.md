# java
1. SegmentedTree --> given an array, you need to find the sum of a given segment. ex: array has 17 elements, indexed 0 to 16. You need to find the sum of segment from index 4 to 11.
We can do it using for loop. But that takes O(nq) to find sum, where n is number of elements in input array , q is number of queries client does. To update a value at a given index,
it takes O(1). With segmented tree, the construction is O(n) and updates can be handled in O(logn)
