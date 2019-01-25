import java.util.Scanner

/**
  * Write a program that counts the total number
  * of vowels in a string.
  *
  */
object VowelsCount extends App {
  // Create a Scanner object for keyboard input.
  val sc = new Scanner (System.in)

  // Ask the user to enter a string
  System.out.print("Enter a string: ")
  val word = sc.nextLine()

  var vowels = "aeiou"
  var vowelCount = 0

  var x = 0
  for( x <- 0 to word.length() - 1){
    if(vowels.contains(String.valueOf(word.charAt(x)))){
      vowelCount += 1
    }
  }

  System.out.println("Total number of vowels is: " + String.valueOf(vowelCount))
}
