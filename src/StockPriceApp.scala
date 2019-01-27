import scala.math._
import scala.util.Try

/**
  * This is program to process Dow Jones Index data sample
  * 1. Using scala.io.Source.fromFile(<filepath>).getLines to read data from
  * dow_jones_index.data into Iterable<String>
  * 2. Convert it to an array of String.
  * 3. Create a case class for StockPrice data
  * 4. Convert Array of String in (1.) to array of StockPrice.
  * 5. Calculate min, max, average of volumes of stock IBM
  * 6. Using groupBy to group stocks by name, calculate highest and lowest price of each
  * stock.
  * 7. Find the stock with maximum, minimum gap between highest and lowest price.
  * 8. Find the date that the gap between open and close price is maximum for each stock.
  *
  */
// Create a case class for StockPrice data
case class StockPrice(
                       quarter: Int,
                       stock: String,
                       date: String,
                       open: Double,
                       high: Double,
                       low: Double,
                       close: Double,
                       volume: Long,
                       percent_change_price: Double,
                       percent_change_volume_over_last_wk: Double,
                       previous_weeks_volume: Long,
                       next_weeks_open: Double,
                       next_weeks_close: Double,
                       percent_change_next_weeks_price: Double,
                       days_to_next_dividend: Double,
                       percent_return_next_dividend: Double) {
}

object StockPriceConvert {
  def apply(fields: Array[String]) = {
    if (fields.length != 16)
      throw new RuntimeException("Wrong number of fields to construct StockPrice object")
    new StockPrice(
      Try(fields(0).toInt).getOrElse(0),
      fields(1),
      fields(2),
      convertPriceToValue(fields(3)),
      convertPriceToValue(fields(4)),
      convertPriceToValue(fields(5)),
      convertPriceToValue(fields(6)),
      Try(fields(7).toLong).getOrElse(0L),
      Try(fields(8).toDouble).getOrElse(0.0),
      Try(fields(9).toDouble).getOrElse(0.0),
      Try(fields(10).toLong).getOrElse(0L),
      convertPriceToValue(fields(11)),
      convertPriceToValue(fields(12)),
      Try(fields(13).toDouble).getOrElse(0),
      Try(fields(14).toDouble).getOrElse(0),
      Try(fields(15).toDouble).getOrElse(0)
    )
  }

  def convertPriceToValue(priceString: String): Double = {
    val regexPrice1 = "\\$[.\\d]+".r
    val regexPrice2 = "[.\\d+]".r
    priceString match {
      case regexPrice1() => priceString.tail.toDouble
      case regexPrice2() => priceString.toDouble
      case _ => throw new NumberFormatException(priceString + ": price is not in correct format")
    }
  }
}

object StockPriceApp extends App {
  //  Read data from dow_jones_index.data then convert it to an array of String.
  val data = scala.io.Source.fromFile("data/dow_jones_index.data").getLines.toArray.tail

  // Convert Array of String to array of StockPrice.
  val stocks = data
    .map(_.split(","))
    .map(fields => StockPriceConvert(fields))

  //Calculate min, max, average of volumes of stock IBM
  val maxIbm = stocks
    .filter(stock => stock.stock == "IBM")
    .map(_.volume)
    .max
  println("Max volume of stock IBM is: " + maxIbm)

  val minIbm = stocks
    .filter(stock => stock.stock == "IBM")
    .map(_.volume)
    .min
  println("Min volume of stock IBM is: " + minIbm)

  val aggIbm = stocks
    .filter(stock => stock.stock == "IBM")
    .map(stock => (stock.volume, 1))
    .foldLeft((0L, 1))( (aggIbm, e) => (aggIbm._1 + e._1, aggIbm._2 + e._2))

  val averageIbm = aggIbm._1.toDouble/ aggIbm._2
  println("Average volume of stock IBM is: " + averageIbm)

  // Using groupBy to group stocks by name, calculate highest and lowest price of each stock
  val maxMin = stocks
    .groupBy(_.stock)
    .mapValues(dataOfStock => {
      val prices = dataOfStock.map(_.open)
      (prices.max, prices.min)
    })
  println("Highest and lowest price of each stock: " + maxMin)

  // Find the stock with maximum, minimum gap between highest and lowest price.
  val maxGap = maxMin
    .maxBy(x => x._2._1 - x._2._2)
  println("Maximum gap between highest and lowest price is " + maxGap)

  val minGap = maxMin
    .minBy(x => x._2._1 - x._2._2)
  println("Minimum gap between highest and lowest price is " + minGap)

  // Find the date that the gap between open and close price is maximum for each stock
  val dateMaxGap = stocks
    .map(stock => (stock.stock, stock.date, abs(stock.open - stock.close)))
    .groupBy(_._1)
    .mapValues(gaps => gaps.maxBy(_._3))
    .values
  println("The date that the gap between open and close price is maximum for each stock: " + dateMaxGap)
}
