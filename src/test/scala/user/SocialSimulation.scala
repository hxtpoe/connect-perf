package user

import io.gatling.core.Predef._
import user.actions._
import java.util.concurrent.ThreadLocalRandom
import scala.concurrent.duration._

class SocialSimulation extends Simulation with GlobalHttpConf {
  val pause = 5 seconds
  val usersScenarios = scenario("Users")
    .exec(User.get(id.toString))
    .exec(Post.get(id.toString)).pause(pause)
    .exec(Post.base("${postNextPage}"))
    .exec(User.get(id.toString))
    .exec(Post.get(id.toString)).pause(pause)
    .exec(Post.base("${postNextPage}"))
    .exec(User.get(id.toString))
    .exec(Post.get(id.toString)).pause(pause)
    .exec(Post.base("${postNextPage}"))
    .exec(User.get(id.toString))
    .exec(Post.get(id.toString)).pause(pause)
    .exec(Post.base("${postNextPage}"))
    .exec(User.get(id.toString))
    .exec(Post.get(id.toString)).pause(pause)
    .exec(Post.base("${postNextPage}"))

    .exec(Post.create(id.toString)).pause(pause)

    .exec(Timeline.get(id.toString)).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)
    .exec(Timeline.base("${timelineNextPage}")).pause(pause)

  setUp(
    usersScenarios.inject(rampUsers(5) over (1 seconds)).protocols(httpConfig())
  ).assertions(
    global.successfulRequests.percent.greaterThan(99)
  )

  def id = ThreadLocalRandom.current().nextInt(1, 100)
}