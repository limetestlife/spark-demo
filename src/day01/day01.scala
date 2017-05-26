package day01

object day01 {
  
  def main(args: Array[String]): Unit = {
    var a:Int =10
    val b = 12
    var c = if(a>12) "ok" else "on ok"
    println(c)
    
    val array = Array(1,2,3,4)
    var ss = for(x <- array  if x>=3)  yield x + 2; 
    
    for (s <- ss){
      println(s)
    }
  }
}