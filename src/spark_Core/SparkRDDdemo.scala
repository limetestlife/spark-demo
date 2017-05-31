package spark_Core
/**
 * @author lime
 * @time 2016-01-01
 * 
 */
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

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