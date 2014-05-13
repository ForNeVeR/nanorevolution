package me.fornever.nano.json

import spray.json._
import DefaultJsonProtocol._
import me.fornever.nanorevolution.macros.{Message, Parsers}

object NanoJsonProtocol extends DefaultJsonProtocol {
  implicit object MessageJsonFormat extends RootJsonFormat[Message] {
    def write(c: Message) =
      throw new Exception("Still not implemented")

    def read(value: JsValue) = {
      value match {
        case map: JsObject =>
          map.getFields("type")(0) match {
            case JsString(typeName) =>
              Parsers.createMessageM(typeName, map)
          }
        case _ => throw new Exception("Error parsing " + value)
      }
    }
  }
}

