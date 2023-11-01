import org.apache.spark.sql.SparkSession
object Spark_Json extends App {

  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")
  val jsonString = """{"Zipcode":704,"ZipCodeType":"STANDARD","City":"PARC PARQUE","State":"PR"}"""
  val data = Seq((1, jsonString))

  import spark.implicits._

  val df = data.toDF("id", "value")
  df.show(false)

  import org.apache.spark.sql.functions.{from_json, col}
  import org.apache.spark.sql.types.{MapType, StringType}

  val df2 = df.withColumn("value", from_json(col("value"), MapType(StringType, StringType)))
  df2.printSchema()
  df2.show(false)

  import org.apache.spark.sql.functions.{to_json}

  df2.withColumn("value", to_json(col("value")))
    .show(false)

  import org.apache.spark.sql.functions.{json_tuple}

  df.select(col("id"), json_tuple(col("value"), "Zipcode", "ZipCodeType", "City"))
    .toDF("id", "Zipcode", "ZipCodeType", "City")
    .show(false)

  import org.apache.spark.sql.functions.{get_json_object}

  df.select(col("id"), get_json_object(col("value"), "$.ZipCodeType").as("ZipCodeType"))
    .show(false)

  import org.apache.spark.sql.functions.{schema_of_json, lit}

  val schemaStr = spark.range(1)
    .select(schema_of_json(lit("""{"Zipcode":704,"ZipCodeType":"STANDARD","City":"PARC PARQUE","State":"PR"}""")))
    .collect()(0)(0)
  println(schemaStr)

}
