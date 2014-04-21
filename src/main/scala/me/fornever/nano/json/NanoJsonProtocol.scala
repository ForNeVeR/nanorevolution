package me.fornever.nano.json

import spray.json._
import DefaultJsonProtocol._

object NanoJsonProtocol extends DefaultJsonProtocol {
  implicit object MessageJsonFormat extends RootJsonFormat[Message] {
    def write(c: Message) =
      throw new Exception("Still not implemented")

    def read(value: JsValue) = {
      value match {
        case map: JsObject =>
          map.getFields("type")(0) match {
            case JsString(typeName) =>
              createMessage(typeName, map)
          }
        case _ => throw new Exception("Error parsing " + value)
      }
    }
  }

  private def createMessage(typeName: String, map: JsObject): Message = {
    typeName match {
      case "A" =>
        map.getFields("login", "password") match {
          case Seq(JsString(login), JsString(password)) => AuthorizeMessage(login, password)
          case _ => throw new Exception("Cannot construct A message from " + map)
        }
      case _ => throw new Exception("Unknown message type " + typeName)
    }
  }
}

