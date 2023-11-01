import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{ArrayType, DataTypes, StringType, StructType}


object Spark_Array extends App {

  val arrayCol = DataTypes.createArrayType(StringType)
  val mapCol = DataTypes.createArrayType(StringType, true)
  val spark: SparkSession = SparkSession.builder()
    .master("local[3]")
    .appName("SparkByExample")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  // Using ArrayType case class
  val caseArrayCol = ArrayType(StringType, false)

  val arrayStructureData = Seq(
    Row("James,,Smith", List("Java", "Scala", "C++"), List("Spark", "Java"), "OH", "CA"),
    Row("Michael,Rose,", List("Spark", "Java", "C++"), List("Spark", "Java"), "NY", "NJ"),
    Row("Robert,,Williams", List("CSharp", "VB"), List("Spark", "Python"), "UT", "NV")
  )
  val arrayStructureSchema = new StructType()
    .add("name", StringType)
    .add("languagesAtSchool", ArrayType(StringType))
    .add("languagesAtWork", ArrayType(StringType))
    .add("currentState", StringType)
    .add("previousState", StringType)
  val df = spark.createDataFrame(
    spark.sparkContext.parallelize(arrayStructureData), arrayStructureSchema)
  df.printSchema()
  df.show()

  df.select(col("name"), col("languagesAtSchool")).show(false)





}
