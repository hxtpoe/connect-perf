package user

import io.gatling.core.Predef._
import user.actions._

import scala.concurrent.duration._

class CounterSimulation extends Simulation with GlobalHttpConf {
  val pause = 0 seconds
  val usersScenarios = scenario("Users")
    .exec(User.count()).pause(pause)
//    .exec(User.freshCount()).pause(pause)

  setUp(usersScenarios.inject(rampUsers(750) over (5 seconds)).protocols(httpConfig())).throttle(
    reachRps(30) in (1 seconds),
    holdFor(5 minute)
  ).assertions(
    global.responseTime.max.lessThan(2000),
    global.successfulRequests.percent.greaterThan(99)
  )
}