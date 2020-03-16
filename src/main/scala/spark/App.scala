package spark;

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.Dataset

case class Record(name: String, region: String, date: String, value: String)

object App {
    def main(args: Array[String]) : Unit = {

    	val sparkSession = SparkSession.builder.master("local")
    										.appName("Spark").config("hive.metastore.uris", "thrift://localhost:9083")
    										.enableHiveSupport()
    										.getOrCreate()

    	import sparkSession.implicits._

    	
    	val ds = sparkSession.read
    					.option("header", "true")
    					.csv("./input/dataset.csv").as[Record];


      //dl_raw     dl_mart     dl_analytics



    	ds.createOrReplaceTempView("mytempTable")

    	sparkSession.sql("create table mytable if not exists as select * from mytempTable");
    }
}