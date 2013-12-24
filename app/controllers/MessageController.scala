package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json.Json
import play.api.Routes

case class Message(value: String)

object MessageController extends Controller {

  implicit val fooWrites = Json.writes[Message]
  
  def getMessage = Action {
    Ok(Json.toJson(Message("Backbone Hello World")))
  }
}