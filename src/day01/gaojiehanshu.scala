package day01

object gaojiehanshu {
  def main(args: Array[String]): Unit = {
    // .map 将一个集合转换成另一个集合，元素个数不会变
    val l = List(1,2,3,4)
    val l2=l.map { x => x+1 }
    println(l2)
    
    val list = List("a","b","c")
    println(list.map ((x) => (x,1)))
    //filter
    println(l.filter { x => x % 2 ==1 })  //filter赛选，true留下，false去掉
    
    //reduce，化简
    //parallelize 并行
    val result = l.par.reduce{(x,y) => println(s"x:$x y:$y 线程名称：" + Thread.currentThread().getName());x+y};
    println(result)
    
    //groupBy
    val map = List(("北京",2),("北京",3),("上海",2),("上海",2),("上海",2),("南京",2),("南京",6))
    val groups = map.groupBy(x => x._1)
    println(groups)
    val ss=groups.mapValues(list => list.map(x=>x._2).reduce((x,y)=> x+y))
    println(ss)
    
  }
}