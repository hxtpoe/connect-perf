package user

object EndPoints {
  val basePath: String = "/api/user"

  def base(path: String) = s"$path"

  def user(id: String) = s"$basePath/$id"

  def posts(id: String): String = s"$basePath/$id/posts"

  def posts(id: String, year: Int, week: Int): String = s"$basePath/$id/posts/$year/$week"

  def timeline(id: String) = s"$basePath/$id/timeline"

  def timeline(id: String, year: Int, week: Int) = s"$basePath/$id/timeline/$year/$week"

  def count() = s"$basePath" + "s/count"
  def freshCount() = s"$basePath" + "s/freshcount"
}