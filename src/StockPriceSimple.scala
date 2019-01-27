/**
 * Create a List of Stock price with data:
 * stock,date,open,high,low,close,volume
 * AA,1/7/11,15.82,16.72,15.78,16.42,239655616
 * AA,1/14/11,16.71,16.71,15.64,15.97,242963398
 * AA,1/21/11,16.19,16.38,15.6,15.79,138428495
 * Write code to:
  * 1. Create a case class StockPrice with fields: stock, date, open, high, low, close, volume
  * 2. Create a List/Seq/ Array of StockPrice with data given.
  * 3. Get the date where volume is highest, lowest.
  * 4. Which date the open price and close price are different the most.
  * 5. Average the volume by date
 */

object StockPriceSimple extends App {
  // 1. Create a case class StockPrice with fields: name, date, open, high, low, close, volume"
  case class StockPrice(
                         name: String,
                         date: String,
                         open: Double,
                         highest: Double,
                         lowest: Double,
                         close: Double,
                         volume: Long
                       )

  // 2. Create a List/Seq/ Array of StockPrice with data given
  val stock: Seq[StockPrice] = Seq(
    StockPrice("AA", "1/7/11", 15.82, 16.72, 15.78, 16.42, 239655616),
    StockPrice("AA","1/14/11", 16.71, 16.71, 15.64, 15.97, 242963398),
    StockPrice("AA", "1/21/11", 16.19, 16.38, 15.6, 15.79, 138428495)
  )

  // 3. Get the date where volume is highest, lowest
  val HighestVolume = stock
    .maxBy(_.volume)
    .volume
  val dateHighestVolume = stock
    .maxBy(_.volume)
    .date
  println("Highest volume is " + HighestVolume + " on " + dateHighestVolume)

  val LowestVolume = stock
    .minBy(_.volume)
    .volume
  val dateLowestVolume = stock
    .minBy(_.volume)
    .date
  println("Lowest volume is " + LowestVolume + " on " + dateLowestVolume)

  // 4. Which date the open price and close price are different the most
  val DiffPrice = stock
    .map(item => Math.abs(item.open - item.close))
  for (st <- stock) {
    if (Math.abs(st.open - st.close) == DiffPrice.max) {
      println("The open price and close price are different the most on: " + st.date)
    }
  }

  // 5. Average the volume by date
  val Average = stock.groupBy(_.date)
  for (x <- Average){
    var Total = 0.0
    var i = 0
    for (y <- stock){
      if (x._1 == y.date){
        Total += y.volume
        i += 1
      }
    }
    val ave_num = Total/i
    println("Average the volume of " + x._1 + " is: " + ave_num)
  }
}