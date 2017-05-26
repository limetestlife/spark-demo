package day01

import scala.io.Source
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object TestWordCount {
  def main(args: Array[String]): Unit = {
    //按行读取，并转化成list
    val list = Source.fromFile("D:/1-spark/word.txt").getLines().toList//读取文件
//    val list1 = list.map { x => (x,1) }
//    val gr = list1.groupBy(x => x._1)
//    val ss = gr.mapValues(list => list.map(tuple => tuple._2).reduce((x,y)=>x+y))
//    //val s = ss.reduce((x,y) => x + y)
//    println(ss)
    
    val cont = list.flatMap { x => x.split(" ") }
                   .groupBy { x => x }
                   .map(x => (x._1,x._2.size))
    cont.foreach(println)
    
//    val sc = new SparkContext(new SparkConf().setAppName("WordCountApp"))
//    val path = "D:/1-spark/README.md"
//    var array = sc.textFile(path).flatMap { x => x.split(" ") }
//                .groupBy { x => x }
//                .map(x => (x._1,x._2.size))
//    array.foreach(println)
    
  }
} 