package spark_SQL

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setMaster("local[2]").setAppName("WordCountApp")
    
    val sc = new SparkContext(conf)
    

    
    
  }
}