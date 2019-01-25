import java.util.Scanner

/**
  * Write a program that accepts length and width
  * of rectangle to find area.
  *
  */

object RectangleArea extends App {
  var length = 0
  var width = 0
  var area = 0

  // Create a Scanner object for keyboard input.
  val sc = new Scanner (System.in)

  // Ask the user to enter the length and width
  System.out.print("Enter value of length: ")
  length = sc.nextInt
  System.out.print("Enter value of width: ")
  width = sc.nextInt

  //  Calculate the area of rectangle
  area = length * width

  // Print out the area of rectangle
  System.out.println()
  System.out.println("Area of rectangle is: " + area)
}
