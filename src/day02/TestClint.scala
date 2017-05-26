package day02

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

object TestClint {
  
  def main(args: Array[String]): Unit = {
    var IP = "127.0.0.1";
    var PORT = "2551";
    
    val conf = new java.util.HashMap[String,Object]()
    conf.put("akka.actor.provider", "akka.remote.RemoteActorRefProvider")
    val list = new java.util.ArrayList[String]()
    list.add("akka.remote.netty.tcp")
    conf.put("akka.remote.enabled-transports", list)
    conf.put("akka.remote.netty.tcp.hostname", IP)
    conf.put("akka.remote.netty.tcp.port", PORT)
    
    val sys = ActorSystem("clint",ConfigFactory.parseMap(conf))
    sys.actorSelection("akka.tcp://sys@127.0.0.1:2550/user/a4") ! "你好。我来自远程客户端"
  }
  
  
  
}