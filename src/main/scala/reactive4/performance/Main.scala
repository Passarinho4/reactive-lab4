package reactive4.performance

import akka.actor.{ActorSystem, Props}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {

  val system = ActorSystem("AuctionSystem")

  val counter = system.actorOf(Props[Counter], "counter")

  for { i <- 0 until 20000 } {
    counter ! Counter.IncrementCommand
  }

  counter ! Counter.PrintCounter

  Await.result(system.whenTerminated, Duration.Inf)

}
