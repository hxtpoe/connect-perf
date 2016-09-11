package user.model

import io.gatling.core.Predef._
import play.api.libs.json.{Format, Json}

case class Post(message: String)

object Post {
  implicit val fmt: Format[Post] = Json.format[Post]

  implicit def toStringBody(post: Post) = StringBody(Json.toJson(post).toString())
}