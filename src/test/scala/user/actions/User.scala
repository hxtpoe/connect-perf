package user.actions

import user.EndPoints
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object User {
  def get(id: String) = http("get user")
    .get(EndPoints.user(id)).asJSON

  def count() = http("count")
    .get(EndPoints.count()).asJSON

  def freshCount() = http("fresh count")
    .get(EndPoints.freshCount()).asJSON
}