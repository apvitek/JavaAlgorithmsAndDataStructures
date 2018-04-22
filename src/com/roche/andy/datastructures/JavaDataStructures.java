package com.roche.andy.datastructures;

/*
Collections are data structures to keep things in memory. Information has to be synced between different data systems.
The choice of a collection depends on functional requirements:
   - Size (in bytes): 10-50k, 50k-2m, >2m and so on.
   - CRUD Operations (which one is faster): Creating VS Reading is checked first, then Reading VS Updating, then
   Updating VS Deleting.
   - Data types

On top of those, there are technical requirements:
   - Contiguous VS Discontiguous, like ArraySize which create fragmentation. Access to discontiguous memory is faster,
 depending on the searching algorithm, whereas contiguous search is faster if based on index.
   - Sorted VS Unsorted data storing. Sorted is expensive, unsorted is cheap, depending on the data type.

Another factor is algorithms used to searching the collection:
   - Sequential search VS Binary search

Possible collections are (n = number of elements:
   - List
        - ArrayList - contiguous unsorted (n < 10,000 since moves are very expensive)
        - LinkedList - discontiguous unsorted (10,000 < n < 100,000)
    Can be implemented as stacks or queues.
   - Set (non-repeating elements, only has key, very fast searches)
        - HashSet - contiguous sorted
        - TreeSet - discontiguous sorted
   - Map (not a collection, unique key and value)
        - HashMap (unsorted dictionary) - contiguous unsorted
        - TreeMap (sorted dictionary) - discontiguous sorted

In Java, trees are implemented as Red-Black trees. A Red-Black Tree solves the issues of constantly balancing
binary trees. The number of levels can be reduced, thus having more horizontal distribution. With a million
values inserted, it takes 22 comparisons to find the right value while searching. Re-balancing can he cheaper
than rehashing the same amount of entries.

In HashMap, the search for a value takes one comparison, but it has a significant overhead. A value used as key must be
unique, and it goes though a hash function which takes the value and saves it in a specific location in an array.
Updating requires rehashing. Memory is wasted to avoid collisions, so there is only a certain threshold of
memory that is used (usually 75%). If keys or size change, the hash function has to rehash and recompute the
entire collection. So to work with then, the size should be chosen accordingly to the amount of data it will
likely host. The drawbacks of hashing are the maintaining a hash table, or an index of key-value pairs. The hash
table helps rebuilding the data structure in case of a crash. There is a cost for inserting and updating data.
In Java, there are almost no collisions, because the percent of occupancy is 75%.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaDataStructures {
    private static void printMap(Map mp) {
        for (Object key : mp.keySet()) {
            System.out.println(key + ": " + mp.get(key));
        }
    }

    public static void main(String args[]) {
        HashMap<Integer, String> unsortedDictionary = new HashMap<>();
        unsortedDictionary.put(5, "1");
        unsortedDictionary.put(2, "4");
        unsortedDictionary.put(4, "2");
        unsortedDictionary.put(1, "5");
        unsortedDictionary.put(3, "3");

        printMap(unsortedDictionary);
        System.out.println();

        TreeMap<Integer, String> sortedDictionary = new TreeMap<>();
        sortedDictionary.put(1, "1");
        sortedDictionary.put(2, "2");
        sortedDictionary.put(3, "3");
        sortedDictionary.put(4, "4");
        sortedDictionary.put(5, "5");

        printMap(sortedDictionary);
    }
}
