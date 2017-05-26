package day01

class Student(name:String,var age:Int) extends Persion(name) {
  
}

object TestStudent{
  def main(args: Array[String]): Unit = {
    var stu = new Student("张三",20);
    println(stu.name)
  }
}