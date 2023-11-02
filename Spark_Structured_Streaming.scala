package org.itc.com

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Spark_Structured_Streaming extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder()
    .appName("SparkStructuredStreamingMaxSensorValue")
    .master("local[*]")
    .getOrCreate()

  import spark.implicits._

  // Define a case class to represent sensor data
  case class SensorData(dateTime: String, sensorName: String, tempValue: Double)

  // Create a streaming DataFrame representing the sensor data from a socket
  val sensorData: DataFrame = spark.readStream
    .format("socket")
    .option("host", "localhost")
    .option("port", 9999)
    .load()

  // Split the "value" column and apply the schema
  val sensorDataDF = sensorData
    .as[String]
    .selectExpr("split(value, ',') as data")
    .select(
      $"data"(0).as("dateTime"),
      $"data"(1).as("sensorName"),
      $"data"(2).cast(DoubleType).as("tempValue")
    )

  // Calculate the maximum temperature for each sensor
  val maxTemperatures = sensorDataDF
    .groupBy("sensorName")
    .agg(max("tempValue").alias("maxTemperature"))

  // Output the maximum temperatures for each sensor to the console
  val query = maxTemperatures.writeStream
    .outputMode("complete")
    .format("console")
    .start()

  query.awaitTermination()
}
