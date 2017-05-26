package day02

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class MyActor extends Actor {
  override def receive: Actor.Receive = {
    case str:String => println(str);
  }
}

class MyActor2(name:String) extends Actor {
  override def receive: Actor.Receive = {
    case str:String => println(str+"name:"+name);
    context.actorOf(Props[MyActor3]) ! "消息来自MyActor2"
  }
}

class MyActor3 extends Actor {
  override def receive: Actor.Receive = {
    case str:String => println(str);
  }
}

object TestClass {
  def main(args: Array[String]): Unit = {
    
    val sys = ActorSystem("helloa");
    val res = sys.actorOf(Props(classOf[MyActor2],"张三"))
    res ! "你好"
  }
}