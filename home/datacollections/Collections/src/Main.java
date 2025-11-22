import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Nothing in the main method will be tested
      int[] twoNumbers = findLargestAndSmallest(new int[]{1,5,7,2,3});
        System.out.println("Smallest and largest = " + twoNumbers);
    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     * <p>
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the largest and smallest.
     * <p>
     * You MAY ONLY use arrays, not other collections types (ie Lists).
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int[] array) {
        int smallest  = array[0] , largest = array[0];

        /*
        * 1 = small
        * large = 5
        *
        * */
///  1,5,7,2,3
/**
 *
 *
 * */
        for (int i = 1; i < array.length; i++) {
            /**
             *
             * if 1 < 5 smallest = 1
             * if 9 < 1 smallest = 1
             * if 2 < 1 smallest = 1
             *             *
             * */
            if (array[i] < smallest) {
                smallest = array[i];
            }
            /**
             *
             * if 1 > 1 largest = 1
             * if 9 > 1 largest = 9
             * if 2 > 9 largest = 9
             * if 88 > 9 largest = 9
             *
             * if 66 > 9 largesr = 9
             *             *
             * */

            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return new int[]{ smallest ,largest};
    }





    /**
     * Question 2: Remove duplicates from an array
     * <p>
     * You are given an array of ints that might have duplicates. You must remove any duplicates from the array,
     * and return an array that doesn't contain duplicates. The order of the elements in the original array
     * does not need to be kept the same.
     * <p>
     * You MAY use any collections types you wish, but the method must return an array.
     * <p>
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param array An array of ints that may or may not include duplicates
     * @return An array of ints that doesn't contain duplicates.
     */
    public static Object[] removeDuplicatesFromArray(int[] array) {

/* Using tee set has expplained by saad unique and return sorted **/
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : array) {
            set.add(num);
        }
        return set.toArray();

    }

    /**
     * Given an array of integers, return the sum of the two largest values.
     * <p>
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(int[] array) {
        /*
        * [1,5,8,9,51,12,254,141,30]
        *
        * */
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        int large = 0, secondLarge =0 ;
//
        if (array[0] > array[1]) {
/**
 *
 * a 0 = 1;
 * a 1 = 5;
 *
 * */
            large = array[0];
            secondLarge = array[1];
        } else {
            /**
             *
             * large = 5;
             * 2nd = 1;
             *
             * */
            large = array[1];
            secondLarge = array[0];
        }
        /*
        *
        * i 8
        *
        * */
        for (int i = 2; i < array.length; i++) {
            if (array[i] > large) {
                secondLarge = large;
                large = array[i];
            } else if (array[i] > secondLarge) {
                secondLarge = array[i];
            }
        }

        return large + secondLarge;
    }


    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     * <p>
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     * <p>
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     * <p>
     * For example:
     * array1 = [1,4,7,9,0,0,0]
     * array2 = [1,5,11]
     * returned array = [1,1,4,5,7,9,11]
     * <p>
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        ArrayList<Integer> merged = new ArrayList<>(array1.length + array2.length);
        /**
         *  array1 = [1,4,7,9,0,0,0]
         * array2 = [1,5,11]
         */

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                break;
            }
            merged.add(array1[i]);
        }

        System.out.println("Megre array" + merged);

        for (int j = 0; j < array2.length; j++) {
            int value = array2[j];

            int index = merged.indexOf(value);
            if (index != -1) {
                merged.add(index + 1, value);
            } else {
                merged.add(value);
            }
        }
//        for (int i = 0; i < merged.size() - 1; i++) {
//            for (int j = 0; j < merged.size() - i - 1; j++) {
//                if (merged.get(j) > merged.get(j + 1)) {
//                    int temp = merged.get(j);
//                    merged.set(j, merged.get(j + 1));
//                    merged.set(j + 1, temp);
//                }
//            }
//        }
        Collections.sort(merged);

        int[] result = new int[merged.size()];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}