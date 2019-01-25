import java.util.Scanner

/**
  * Determine if a number is an Armstrong number
  *
  */
object ArmstrongNumber extends App {
    // Create a Scanner object for keyboard input.
    val sc = new Scanner (System.in)

    // Ask the user to enter a number
    System.out.print("Enter a number: ")
    val x = sc.nextInt

    // Check if entered number is an Armstrong number or not
    if (isArmstrongNumber(x))
      System.out.println("This is an Armstrong number")
    else
      System.out.println("This is not an Armstrong number")

  def isArmstrongNumber(number: Int): Boolean = {
    val digits = number.toString
    val digitize: Char => Int = _.asDigit
    val power: Int => Double = math.pow(_, digits.length)
    number == digits.map(digitize andThen power).sum
  }
}