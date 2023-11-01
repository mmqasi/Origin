import org.apache.spark.sql.SparkSession
object SparkSession_Example extends App {
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate();
  println(spark)
  println("Spark Version : " + spark.version)

  val spark2 = SparkSession.builder().getOrCreate()
  print(spark2)

  // Create a new SparkSession
  val spark3 = spark.newSession()
  print(spark3)

  // Usage of config()
  val spark4 = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .config("spark.some.config.option", "config-value")
    .getOrCreate();

  // Enabling Hive to use in Spark
  val spark5 = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .config("spark.sql.warehouse.dir", "<path>/spark-warehouse")
    .enableHiveSupport()
    .getOrCreate();

  // Set Config
  spark.conf.set("spark.sql.shuffle.partitions", "30")

  // Get all Spark Configs
  val configMap: Map[String, String] = spark.conf.getAll

  // Create DataFrame
  val df = spark.createDataFrame(
    List(("Scala", 25000), ("Spark", 35000), ("PHP", 21000)))
  df.show()

  // Spark SQL
  df.createOrReplaceTempView("sample_table")
  val df2 = spark.sql("SELECT _1,_2 FROM sample_table")
  df2.show()

  // Create Hive table & query it.
  spark.table("sample_table").write.saveAsTable("sample_hive_table")
  val df3 = spark.sql("SELECT _1,_2 FROM sample_hive_table")
  df3.show()

  // Get metadata from the Catalog
  // List databases
  val ds = spark.catalog.listDatabases
  ds.show(false)

  // List Tables
  val ds2 = spark.catalog.listTables
  ds2.show(false)
}
