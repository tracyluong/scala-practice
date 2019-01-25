import java.util.Scanner

/**
  * Write a program that checks if a string is a palindrome.
  *
  */
object Palindrome extends App {
  // Create a Scanner object for keyboard input.
  val sc = new Scanner (System.in)

  // Ask the user to enter a string
  System.out.print("Enter a string: ")
  val word = sc.nextLine()
  val tempWord: String = new StringBuffer(word).reverse.toString

  if (word == tempWord)
    System.out.println(word + " is a palindrome")
  else
    System.out.println(word + " is not a palindrome")
}
