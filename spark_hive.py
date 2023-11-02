import findspark
findspark.init()

import pyspark
from pyspark.sql import SparkSession
from pyspark.sql import SQLContext
from pyspark.sql.types import StructType, StructField, IntegerType, StringType
from pyspark.sql import HiveContext

# Initialize a Spark session
spark = SparkSession.builder \
    .appName("Spark Hive Integration") \
    .config("spark.sql.warehouse.dir", "local[1]") \
    .enableHiveSupport() \
    .getOrCreate()

# Define the schema
schema = StructType([
    StructField("User ID", IntegerType(), True),
    StructField("Username", StringType(), True),
    StructField("Browser", StringType(), True),
    StructField("OS", StringType(), True),
])

data = [
    (1580, "Barry", "FireFox", "Windows"),
    (5820, "Sam", "MS Edge", "Linux"),
    (2340, "Harry", "Vivaldi", "Windows"),
    (7860, "Albert", "Chrome", "Windows"),
    (1123, "May", "Safari", "macOS"),
]

# Create a DataFrame
df = spark.createDataFrame(data, schema)
df.show()

# Create a Hive table
df.createOrReplaceTempView("user_data")

spark.sql("Select * From user_data").show()



# Show the data from the Hive table
spark.sql("SELECT * FROM user_data").show()

# Stop the Spark session
spark.stop()