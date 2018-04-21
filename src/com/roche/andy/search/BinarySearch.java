package com.roche.andy.search;

/*
 Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole
 array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to
 the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is
 empty.

 1. Compare x with the middle element.
 2. If x matches with middle element, we return the mid index.
 3. Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element.
    So we recur for right half.
 4. Else (x is smaller) recur for the left half.
 */

// Java implementation of recursive Binary Search
class BinarySearch {
    // Returns index of element if it is present in array[left...right], else returns -1
    private int binarySearch(int array[], int left, int right, int element) {
        if (right >= left) {
            int middle = left + (right - left) / 2;

            // If the element is present at the middle itself
            if (array[middle] == element) {
                return middle;
            }

            // If element is smaller than middle, then it can only be present in left subarray
            if (array[middle] > element) {
                return binarySearch(array, left, middle - 1, element);
            }

            // Else the element can only be present in right subarray
            return binarySearch(array, middle + 1, right, element);
        }

        // We reach here when element is not present in array
        return -1;
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Driver method to test above
    public static void main(String args[]) {
        BinarySearch binarySearch = new BinarySearch();
        int array[] = {2, 3, 4, 10, 40};
        int element = 10;

        int result = binarySearch.binarySearch(array, 0, array.length - 1, element);

        if (result == -1) {
            System.out.println("Element not present");

        } else {
            System.out.println("Element found at index " + result);
        }
    }
}