package me.fornever.nano

import spray.json._
import me.fornever.nano.json._
import me.fornever.nanorevolution.macros.Message

object Parser {
  def parse(request: String): Message = {
    import NanoJsonProtocol._
    request.parseJson.convertTo[Message]
  }
}
