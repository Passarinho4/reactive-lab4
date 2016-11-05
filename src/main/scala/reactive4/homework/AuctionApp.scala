package reactive4.homework

import akka.actor.{ActorSystem, Props}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object AuctionApp extends App {

  val system = ActorSystem("AuctionSystem")

  val mainActor = system.actorOf(Props[AuctionService], "mainActor")

  mainActor ! AuctionService.Init

  Await.result(system.whenTerminated, Duration.Inf)
}
