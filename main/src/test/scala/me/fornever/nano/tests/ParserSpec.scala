package me.fornever.nano.tests

import org.scalatest.{Matchers, FlatSpec}
import me.fornever.nano.Parser
import me.fornever.nano.json.AuthorizeMessage

class ParserSpec extends FlatSpec with Matchers {
  "A Parser" should "parse the AuthorizeMessage" in {
    val request =
      """{
        |   "type": "A",
        |   "login": "l",
        |   "password": "p"
        | }""".stripMargin
    val message = Parser.parse(request).asInstanceOf[AuthorizeMessage]
    assert(message.login == "l")
    assert(message.password == "p")
  }
}
