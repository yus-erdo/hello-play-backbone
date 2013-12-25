package test

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import play.api.http.ContentTypes.JSON
import play.api.libs.json.Json
import play.api.libs.json.JsObject
import play.api.libs.json.JsValue
import play.api.libs.json.JsString

/**
 * Specs2 tests
 */
class MessageControllerSpec extends Specification {
  
  case class Message(val value: String)
  
  "MessageController" should {
    
    "getMessage should return JSON" in new WithApplication {
      val result = controllers.MessageController.getMessage(FakeRequest())

      status(result) must equalTo(OK)
      contentType(result) must beSome("application/json")
      charset(result) must beSome("utf-8")            
      contentAsJson(result) must equalTo(JsObject(Seq(("value" -> JsString("Backbone Hello World")))))
    }

  }
}