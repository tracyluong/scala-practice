/**
  * Write a program that outputs the frequency of a letter in a string.
  *
  */
object FrequencyLetter extends App {
  var word = "Scala programming is fun"
  var letter = "a"
  var letterCount = 0

  var x = 0;
  for (x <- 0 to word.length() - 1) {
    if (letter.contains(String.valueOf(word.charAt(x)))) {
      letterCount += 1
    }
  }

  println("Letter " + letter + " appears " + String.valueOf(letterCount) + " time(s)")
}