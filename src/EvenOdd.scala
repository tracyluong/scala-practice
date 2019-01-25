import java.util.Scanner

/**
  * Write a program which repeatedly prompts the user for an integer.
  * Check if that is an even or odd then print out.
  * Exit the program if the user enters -1
 */
object EvenOdd extends App {
  var evaluator=true
  do{
    // Create a Scanner object for keyboard input.
    val sc = new Scanner (System.in)

    // Ask the user to enter a number
    System.out.print("Enter an integer (0 to exit): ")
    val num = sc.nextInt

    // Check odd or even
    if(num < 0) println("Invalid number! Enter an integer (0 to exit): ")
    else {
      if(num%2 == 0)
        System.out.println("This is an even number")
      else
        System.out.println("This is an odd number")
    }
    evaluator = if(num == 0) {print("Exiting..."); false} else true
  } while(evaluator)
}
