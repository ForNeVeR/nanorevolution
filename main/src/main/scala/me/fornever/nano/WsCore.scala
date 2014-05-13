package me.fornever.nano

import akka.actor.{ActorRef, Actor, ActorLogging}
import org.mashupbots.socko.events.WebSocketFrameEvent
import io.netty.channel.Channel

class WsCore extends Actor with ActorLogging {
  var clients = Map[Channel, ActorRef]()

  def receive = {
    case frame: WebSocketFrameEvent =>
      val request = frame.readText()
      val channel = frame.context.channel()

      dispatchMessage(channel, request)
  }

  def dispatchMessage(channel: Channel, request: String) {
    val message =
    clients.get(channel) match {
      //case Some(client) => client ! WsMessage(request)
      case None => authorize(channel, request)
    }
  }

  def authorize(channel: Channel, request: String) {

  }
}
