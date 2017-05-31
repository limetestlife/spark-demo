package spark_Core

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
/**
 * 该类在spark程序中属于驱动器程序，在该程序中包含了main方法，在该类中定义了集群中所有的运算方式。
 * 该驱动器程序是通过SparkContext来和集群联系的。所以在驱动器程序中代码大致分为三部分：1.创建SparkContext。2.运算。3.关闭SparkContext
 */
object SparkRDDdemo {
  def main(args: Array[String]): Unit = {
    /**
     * Configuration for a Spark application 。spark应用的配置
     * 在该配置中可以设置很多参数
     */
    val conf = new SparkConf().setMaster("local[2]").setAppName("WordCountApp")
    /**
     * driver的入口，服务端的入口，其用来连接集群，创建rdd，广播变量
     */
    val sc = new SparkContext(conf)
    /**
     * 创建RDD的方式
     * 		1.sc.parallelize
     * 		2.sc.makeRDD
     * 
     */
     //var rdd1 =sc.parallelize(List(1,2,3,4), 2);
     //val rdd2 =sc.makeRDD(List(1,2,3,4,5),2)
    /**
     * RDD的主要方法
     */
    val path = "D:/1-spark/README.md"
    var array = sc.textFile(path).flatMap { x => x.split(" ") }
                .groupBy { x => x }
                .map(x => (x._1,x._2.size))
    array.foreach(println)
    
    while(true){}
    
    
    //停止
    sc.stop();
     
  }
}