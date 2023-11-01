import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.Row
import scala.collection.JavaConversions._

object Data_Frames extends App {

  // Create SparkSession and Prepare Data
  val spark: SparkSession = SparkSession.builder()
    .master("local[1]").appName("SparkByExamples.com")
    .getOrCreate()

  import spark.implicits._

  val columns = Seq("language", "users_count")
  val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))


  // Spark Create DataFrame from RDD
  val rdd = spark.sparkContext.parallelize(data)

  //val dfFromRDD1 = rdd.toDF()
  //dfFromRDD1.printSchema()

  val dfFromRDD1 = rdd.toDF("language", "users_count")
  dfFromRDD1.printSchema()

  val dfFromRDD2 = spark.createDataFrame(rdd).toDF(columns:_*)

  val schema = StructType(Array(
    StructField("language", StringType, true),
    StructField("users", StringType, true)
  ))
  val rowRDD = rdd.map(attributes => Row(attributes._1, attributes._2))
  val dfFromRDD3 = spark.createDataFrame(rowRDD, schema)



  import spark.implicits._
  val dfFromData1 = data.toDF()

  // From Data (USING createDataFrame)
  var dfFromData2 = spark.createDataFrame(data).toDF(columns: _*)

  // From Data (USING createDataFrame and Adding schema using StructType)
  val rowData = Seq(Row("Java", "20000"),
    Row("Python", "100000"),
    Row("Scala", "3000"))
  var dfFromData3 = spark.createDataFrame(rowData, schema)

  // Create Spark DataFrame from CSV
  //val df2 = spark.read.csv("/src/resources/file.csv")


  // Creating from text (TXT) file
  //val df3 = spark.read
    //.text("/src/resources/file.txt")

  //val df4 = spark.read
    //.json("/src/resources/file.json")






}
