import java.util.Scanner
/**
  * Write a program that counts total number
  * of digits in a string using Regular Expression.
  *
  */
object NumberCount extends App {
  // Create a Scanner object for keyboard input.
  val sc = new Scanner (System.in)

  // Ask the user to enter a string
  System.out.print("Enter a string: ")
  val word = sc.nextLine()

  // Count the total number of digits then print out
  val count: Int = word.replaceAll("[^0-9]", "").length
  System.out.println("Total number of digits in this string is: " + count)
}
