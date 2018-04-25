package com.roche.andy.sort;

/*
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in
wrong order.

Example:
First Pass:
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole
pass without any swap to know it is sorted.

Third Pass:
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

Time complexity: O(n^2) (average and worst case, even if sorted)
Space complexity: O(1)
*/

// Java program for implementation of Bubble Sort
class BubbleSort {
    public static void bubbleSort(int array[], int arrayLength) {
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap temp and array[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Prints the array
    public static void printArray(int array[]) {
        for (int element : array) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String args[]) {
        int array[] = {64, 34, 25, 12, 22, 11, 90};

        System.out.print("Original array: ");
        printArray(array);

        bubbleSort(array, array.length);

        System.out.print("Sorted array: ");
        printArray(array);
    }
}