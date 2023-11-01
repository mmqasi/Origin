import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark
import org.apache.spark.sql.functions.array_contains
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel
object DF_Cache_Persist extends App{

  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate()

  //read csv with options
  val df = spark.read.options(Map("inferSchema" -> "true", "delimiter" -> ",", "header" -> "true"))
    .csv("src/main/resources/zipcodes.csv")

  val df2 = df.where(col("State") === "PR").cache()
  df2.show(false)

  println(df2.count())

  val df3 = df2.where(col("Zipcode") === 704)

  println(df2.count())

  val dfPersist = df.persist()
  dfPersist.show(false)

  val dfPersist2 = df.persist(StorageLevel.MEMORY_ONLY)
  dfPersist2.show(false)

  val dfPersist3 = dfPersist.unpersist()

}
