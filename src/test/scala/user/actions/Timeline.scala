package user.actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import user.EndPoints

object Timeline {
  def baseWithParse(path: String) = http("next timeline")
    .get(EndPoints.base(path))
    .check(status.is(200))
    .check(jsonPath("$.nextPage").saveAs("timelineNextPage"))

  def base(path: String) = http("next timeline")
    .get(EndPoints.base(path))

  def get(id: String) = http("get timeline")
    .get(EndPoints.timeline(id))
    .check(status.is(200))
    .check(jsonPath("$.nextPage").saveAs("timelineNextPage"))
}