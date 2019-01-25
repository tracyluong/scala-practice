import java.util.Scanner

/**
  * Design a class calculator which can take two integers,
  * and four methods that does the addition,
  * subtraction, division and multiplication
  * of these two numbers.
  *
  */
object Calculator extends App {
  // Create a Scanner object for keyboard input.
  val sc = new Scanner (System.in)

  // Ask the user to enter the params
  System.out.print("Enter 1st param: ")
  val value1 = sc.nextInt
  System.out.print("Enter 2nd param: ")
  val value2 = sc.nextInt


  val cal = new Calculator(value1, value2)
  System.out.println("The addition is: "+cal.addition)
  System.out.println("The subtraction is: "+cal.subtraction)
  System.out.println("The multiplication is: "+cal.multiplication)
  System.out.println("The division is: "+cal.division)

}

class Calculator(param1 :Int, param2:Int){
  def addition=param1+param2;
  def subtraction=param1-param2;
  def multiplication=param1*param2;
  def division= param1/param2;
}