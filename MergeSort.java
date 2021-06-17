
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Class implementing the merge sort algorithm.
 *
 */
public class MergeSort {

  /**
   * Merge two sorted subsequences in an array into one sequence. Assuming
   * that arr[p .. q] and arr[q + 1 .. r] are sorted subsequence, merge their
   * contents into arr[p .. r], forming a single sorted sequence.
   *
   * @param arr Array of integers that's being sorted
   * @param p   First subsequence index
   * @param q   Second subsequence index
   * @param r   Third subsequence index
   */
  private static void merge(int[] arr, int p, int q, int r) {
    int n1 = q - p + 1; // size of left subsequence
    int n2 = r - q;     // size of right subsequence
    int i, j, k;        // scractch array indices

    // create scratch arrays
    int[] left = new int[n1 + 1];
    int[] right = new int[n2 + 1];

    // copy subsequences into scratch arrays
    for (i = 0; i < n1; i++) {
      left[i] = arr[p + i];
    }

    for (j = 0; j < n2; j++) {
      right[j] = arr[q + 1 + j];
    }

    // tack on sentinels
    left[n1] = Integer.MAX_VALUE;
    right[n2] = Integer.MAX_VALUE;

    // merge back into array
    i = 0;
    j = 0;
    for (k = p; k <= r; k++) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      } // if / else
    }   // for k
  }     // merge

  /**
   * Sort an integer array using the merge sort algorithm. This is the
   * recursive helper method that sorts elements in the subarray arr[p .. r].
   *
   * @param arr integer array to sort
   * @param p   left index of subarray to sort
   * @param r   right index of subarray to sort
   */
  private static void mergeSort(int[] arr, int p, int r) {
    // only sort if the array is larger than one element
    if (p < r) {
      // compute midpoint
      int q = (p + r) / 2;

      // sort each half
      mergeSort(arr, p, q);
      mergeSort(arr, q + 1, r);

      // merge results
      merge(arr, p, q, r);
    } // if
  }   // mergeSort

  /**
   * Sort an integer array using the merge sort algorithm.
   *
   * @param arr integer array to sort
   */
  public static void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
  } // mergeSort

  /**
   * Fill an integer array with random numbers, using the specified random
   * number generator.
   *
   * @param arr  Array to fill
   * @param prng Random number generator to use to fill the array
   */
  public static void fillArray(int[] arr, Random prng) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = prng.nextInt(1000);
    }
  }

  /**
   * Method to test mergeSort. Prompts user for array size, creates / fills
   * the array, and then sorts it. 
   */
  public static void runMergeSort() {
    System.out.println("==============================================");
    System.out.println("  Merge sort example");
    System.out.println("==============================================");
    Scanner stdin = new Scanner(System.in);
    Random prng = new Random();
    int n = -1;

    System.out.print("Enter array size (neg. to quit): ");
    n = stdin.nextInt();
    while (n >= 0) {
      int[] arr = new int[n];

      fillArray(arr, prng);

      System.out.println("Array before sorting: ");
      System.out.println(Arrays.toString(arr));
      mergeSort(arr);
      System.out.println("Array after sorting: ");
      System.out.println(Arrays.toString(arr));

      System.out.print("\nEnter array size (neg. to quit): ");
      n = stdin.nextInt();

    } // while

  } // main

} // MergeSort
