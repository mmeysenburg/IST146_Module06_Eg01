import java.util.Scanner;

/**
 * Fibonacci: class to compute f_n using recursion.
 *
 */
public class Fibonacci {

  /**
   * Calculate f_n
   * @param n natural number n as a long
   * @return f_n as a long
   */
  private static long fibonacci(long n) {
    if (n > 2) {
      return fibonacci(n - 1) + fibonacci(n - 2);
    } else {
      return 1;
    }
  } // fibonacci

  /**
   * Method to test the fibonacci() method. Prompts
   * user for n, and computes f_n. Repeat until the user enters
   * a negative value for n.
   */
  public static void runFibonacci() {
    System.out.println("==============================================");
    System.out.println("  Fibonacci example");
    System.out.println("==============================================");
    Scanner stdin = new Scanner(System.in);
    long n;

    // priming read -- get first value of n
    System.out.print("Enter n (negative to quit): ");
    n = stdin.nextLong();

    // keep going until a negative n is input
    while (n >= 0L) {
      // calculate and display f_n
      System.out.println("f_" + n + " = " + fibonacci(n));

      // get next value
      System.out.print("Enter n (negative to quit): ");
      n = stdin.nextLong();
    }
  }
}
