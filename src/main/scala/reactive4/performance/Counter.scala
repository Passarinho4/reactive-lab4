package reactive4.performance

import akka.persistence.{PersistentActor, RecoveryCompleted}

class Counter extends PersistentActor {
  import Counter._

  override def persistenceId: String = "test-persistent-actor-counter"

  var state = CounterState(0)
  val objectCreatedTime = System.nanoTime()

  def updateState(event: IncrementedEvent) = this.state = CounterState(state.counter + 1)

  override def receiveRecover: Receive = {
    case event: IncrementedEvent => updateState(event)
    case event: RecoveryCompleted => println(s"Recovery time in seconds: ${(System.nanoTime() - objectCreatedTime).toSeconds}")
  }

  override def receiveCommand: Receive = {
    case IncrementCommand => persist(IncrementedEvent())(updateState)
    case PrintCounter => {
      println(s"Counter value: ${state.counter}")
      println(s"Write time in seconds: ${(System.nanoTime() - objectCreatedTime).toSeconds}")
    }
  }

}
object Counter {

  case object IncrementCommand
  case object PrintCounter
  case class IncrementedEvent()

  case class CounterState(counter: Long)

  implicit class Nanoseconds(nanoseconds: Long) {
    def toSeconds = nanoseconds / 1000000000d
  }
}