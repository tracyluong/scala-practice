import java.util.Scanner;

/**
  * Write a program that accepts three numbers and print out their average.
  *
  */
object AverageCalculation extends App {
  var num1 = 0;
  var num2 = 0;
  var num3 = 0;
  var average = 0;

  // Create a Scanner object for keyboard input.
  var sc = new Scanner(System.in);

  // Ask the user to enter three numbers
  System.out.print("Enter value of 1st number: ");
  num1 = sc.nextInt();
  System.out.print("Enter value of 2nd number: ");
  num2 = sc.nextInt();
  System.out.print("Enter value of 3rd number: ");
  num3 = sc.nextInt();

  // Calculate the average of three numbers
  average = (num1 + num2 + num3) / 3;

  // Print out the average
  println("Average is: "  + average);
}
