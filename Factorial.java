import java.util.Scanner;

/**
 * Factorial: class to compute n! using recursion.
 *
 */
public class Factorial {

  /**
   * Calculate n!
   * @param n natural number n as a long
   * @return n! as a long
   */
  private static long factorial(long n) {
    if (n > 0) {
      return n * factorial(n - 1);
    } else {
      return 1;
    }
  } // factorial

  /**
   * Method to test the factorial() method. Prompts
   * user for n, and computes n!. Repeat until the user enters
   * a negative value for n.
   *
   */
  public static void runFactorial() {
    System.out.println("==============================================");
    System.out.println("  Factorial example");
    System.out.println("==============================================");
    Scanner stdin = new Scanner(System.in);
    long n;

    // priming read -- get first value of n
    System.out.print("Enter n (negative to quit): ");
    n = stdin.nextLong();

    // keep going until a negative n is input
    while (n >= 0L) {
      // calculate and display n!
      System.out.println(n + "! = " + factorial(n));

      // get next value
      System.out.print("Enter n (negative to quit): ");
      n = stdin.nextLong();
    }
  }
}
