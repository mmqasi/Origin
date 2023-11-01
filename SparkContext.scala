import org.apache.spark.sql.SparkSession

object SparkContext extends App {
  // Create SparkSession object
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate();

  // Access spark context
  println(spark.sparkContext)
  println("Spark App Name : " + spark.sparkContext.appName)

  // Create RDD
  val rdd = spark.sparkContext.range(1, 5)
  rdd.collect().foreach(print)

  // Create RDD from Text file
  val rdd2 = spark.sparkContext.textFile("src/main/resources/text/alice.txt")

  // SparkContext stop() method
  spark.sparkContext.stop()




}
