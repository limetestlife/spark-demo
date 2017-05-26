package streaming

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds


object Stream {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()    
    conf.setMaster("local[3]").setAppName("WordCountApp")   
    val sc = new SparkContext(conf)
    //seconds(1)表示每隔一秒收集一次数据封装为DStream
    val ssc = new StreamingContext(sc, Seconds(1))
    val ds = ssc.textFileStream("D:/1-spark/data")
    //println(ds)
    val rr = ds.map{ x => (x, 1) }.reduceByKey( (x,y)=> x+y )
    //ds.map{ x => (x, 1) }.reduceByKey( (x,y)=> x+y ).saveAsTextFiles("D:/1-spark/ss/tt")
    rr.print()
    ssc.start()
    
  }
}