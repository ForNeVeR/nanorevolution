package me.fornever.nano

import spray.json._
import me.fornever.nano.json._

object Parser {
  def parse(request: String): Message = {
    import NanoJsonProtocol._
    request.parseJson.convertTo[Message]
  }
}
