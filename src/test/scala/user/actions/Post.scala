package user.actions

import faker.Lorem
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import user.EndPoints
import user.model.{Post => PostModel}

object Post {
  def base(path: String) = http("next posts")
    .get(EndPoints.base(path))

  def baseWithParse(path: String) = http("next posts")
    .get(EndPoints.base(path))
    .check(status.is(200))
    .check(jsonPath("$['nextPage']").saveAs("postNextPage"))

  def get(id: String) = http("get posts")
    .get(EndPoints.posts(id))
    .check(status.is(200))
    .check(jsonPath("$['nextPage']").saveAs("postNextPage"))

  def create(id: String) = http("create post")
    .post(EndPoints.posts(id))
    .header("Content-Type", "application/json")
    .body(PostModel(Lorem.paragraph(3)))
}