package spark_SQL

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.DataFrame

object sparkSQL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()    
    conf.setMaster("local[2]").setAppName("WordCountApp")   
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    
    // 当遇到shuffle 运算时，使用的partitions个数
    sqlContext.setConf("spark.sql.shuffle.partitions","2")

    //将普通rdd转换为dataframe需要的
    import sqlContext.implicits._
    //定义两个dataframe
   /* val df1 =  sc.parallelize(List( (1,"张三",10),(2,"李四",20),(3,"王五", 20), (4,"赵六", 40)))
            .toDF("id", "name", "deptid")
    val df2 = sc.parallelize(List( (10, "市场部"),(20, "教学部")  )).toDF("did", "dname")
    //将两个df连接查询
    df1.join(df2, $"deptid" === $"did", "inner").show()
    df1.join(df2, $"deptid" === $"did", "left").show()
    //对df做运算操作
    df1.select($"id" + 1).show()
    
    val df3 = sc.parallelize(List( ("张三", Array(1,2,3))  )).toDF("name", "fn")
    // 根据表达式进行查询
    df3.selectExpr("fn[0]").show*/

    //val df4 = sqlContext.read.json("D:/1-spark/sql.json")
    //查看数据结构
    //df4.printSchema()
    
    //df4.select($"name").show()
    //df4.select("name","address.city","address.street").show()
    
    //val s = df4.count()
    //println(s)
    
    //val row = df4.first()
    //val name = row.getString(1)
    //println(name)
    
     //df4.show(100) //前100行
    // df4.show()  //前20行
    
     // 如何关系型数据库获取数据，创建dataFrame对象
    /*val prop = new java.util.Properties
    prop.put("user", "root")
    prop.put("password", "root")
    val df6 = sqlContext.read.jdbc("jdbc:mysql://localhost:3306/test", "rbac_menu", prop)*/
    
    // 注意：通过jdbc创建需要数据库驱动包，并添加启动参数，例如：
    // bin/spark-shell --master=local --driver-class-path=mysql-connector-java-5.1.32.jar
    // bin/spark-submit ... --driver-class-path=mysql-connector-java-5.1.32.jar

//    df6.select($"id",$"menuname").show()
    
 /*   df6.registerTempTable("menu")
    sqlContext.sql("select  id,parentid,menuname from menu order by id desc").show()*/
    
    //用sql风格实现单词计数
    sc.textFile("D:/1-spark/README.md").flatMap { x => x.split(" ") }.toDF("word").registerTempTable("words")
      
    //sqlContext.sql("select word, count(*) c from words group by word order by c desc limit 3").show
    sqlContext.sql("select word,count(*) from words group by word").show(100)
    
    
    
    
    sc.stop()
  }
}