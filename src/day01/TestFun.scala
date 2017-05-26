package day01

object TestFun {
  
  def main(args: Array[String]): Unit = {
    
    //list集合，list内容不可变，即list只读
    val list = List(1,2,3,4)
    println(list.head)  //获取第一个元素
    println(list(3))    //获取下标为3元素，性能比较差，因其实现是链表
    println(list.length)   //获取list长度
    val list2 = list :+ 5  //在后面扩存集合，生成新的集合
    println(list2)
    
    val list3 = 7 +: list //在前面添加元素
    println(list3)
    
    val list4 = list2 ::: list3
    println(list4)      //合并
    
    
    
    val set = Set(1,1,2,2,3) //set里没有重复元素 
    println(set)
    
    
    val map = Map(1 -> "北京",2 -> "上海")  //mutable中的map集合不可变
    println(map)
    val map2 = map+(3->"深圳")            //添加元素
    println(map2)
    val map3 = map -2                  //删除元素，删除只知道键值就可以
    println(map3)
    
    
    //tuple,元组
    val t1=(1,"北京")  //
    println(t1._1)    //访问第一个
    println(t1._2)    //访问第二个
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
  
 
  
}