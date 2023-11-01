import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Spark_SQL_Date_Time extends App {

  val spark: SparkSession = SparkSession.builder()
    .master("local[3]")
    .appName("SparkByExample")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  import spark.sqlContext.implicits._


  Seq(("2019-01-23"))
    .toDF("Input")
    .select(
      current_date() as ("current_date"),
      col("Input"),
      date_format(col("Input"), "MM-dd-yyyy").as("format")
    ).show()


}
