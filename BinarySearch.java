import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * BinarySearch: class implementing a recursive binary search.
 */
public class BinarySearch {

  /**
   * Search an integer array for a specific key, using recursive
   * binary search.
   *
   * @param arr Array to search
   * @param key Key to search for
   * @param lo First index of portion to search
   * @param hi Last index of portion to search
   * @return An index where key was found, or -1 if key is not
   * in the array.
   */
  private static int binarySearch(int[] arr, int key, int lo, int hi) {
    // base case 1: range indices crossing means
    // key is not in the array
    if (hi < lo) {
      return -1;
    } else {
      // compute index of our guess -- right in the middle of
      // the array
      int mid = (lo + hi) / 2;

      // base case 2: our guess is correct!
      if (key == arr[mid]) {
        return mid;
      } else if (key < arr[mid]) {
        // general case 1: key is less than value at the middle
        return binarySearch(arr, key, lo, mid - 1);
      } else {
        // general case 2: key is greater than value at the middle
        return binarySearch(arr, key, mid + 1, hi);
      }
    }
  }

  /**
   * Method to test binarySearch. Creates, fills, and sorts a search
   * array, then prompts the user to enter search keys.
   */
  public static void runBinarySearch() {
    System.out.println("==============================================");
    System.out.println("  Binary search example");
    System.out.println("==============================================");

    Random prng = new Random();
    Scanner stdin = new Scanner(System.in);

    // create, populate, and sort an array of ints
    int[] arr = new int[20];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = prng.nextInt(100);
    }
    Arrays.sort(arr);

    // prompt user to enter a search key
    System.out.println("Array:");
    System.out.println(Arrays.toString(arr));
    System.out.println();
    System.out.print("Enter key to search for (negative to quit): ");
    int key = stdin.nextInt();

    // keep going until a negative value is entered
    while (key >= 0) {
      // perform search
      int index = binarySearch(arr, key, 0, arr.length - 1);

      // output results
      if (index >= 0) {
        System.out.printf("Key %d found at index %d.\n", key, index);
      } else {
        System.out.printf("Key %d not found.\n", key);
      }

      // prompt user to enter next search key
      System.out.println();
      System.out.println("Array:");
      System.out.println(Arrays.toString(arr));
      System.out.println();
      System.out.print("Enter key to search for (negative to quit): ");
      key = stdin.nextInt();
    }
  }
}
