package day02

import akka.actor.Actor
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

object yuancheng {
  def main(args: Array[String]): Unit = {
    var IP = "127.0.0.1";
    var PORT = "2550";
    
    val conf = new java.util.HashMap[String,Object]()
    conf.put("akka.actor.provider", "akka.remote.RemoteActorRefProvider")
    val list = new java.util.ArrayList[String]()
    list.add("akka.remote.netty.tcp")
    conf.put("akka.remote.enabled-transports", list)
    conf.put("akka.remote.netty.tcp.hostname", IP)
    conf.put("akka.remote.netty.tcp.port", PORT)
    
    val sys = ActorSystem("sys",ConfigFactory.parseMap(conf))
    sys.actorOf(Props[MyActor4],"a4")
    
  }
}

class MyActor4 extends Actor {
  override def receive: Actor.Receive = {
    case str:String => println(str);
  }
}