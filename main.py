import sys

from pyspark import SparkContext

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    sc = SparkContext(appName="MyFirstSPARK_Application")

    fileRDD = sc.textFile("C:\\Users\\mmqas\\OneDrive\\Desktop\\Data.txt")
    # accepts one line and return many words 1 to M
    # It will take line by line and will read whole file
    wordsRDD = fileRDD.flatMap(lambda x: x.lower().split(" "))
    # 1 to 1
    wordRDD = wordsRDD.map(lambda x: (x,1))
    # Aggregation
    finalOutput = wordRDD.reduceByKey(lambda x,y: x + y).collect()
    # print final output to screen.
    for i in finalOutput:
        print(i)
