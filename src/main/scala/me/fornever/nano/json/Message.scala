package me.fornever.nano.json

abstract sealed class Message()
case class AuthorizeMessage(login: String, password: String) extends Message
case class AuthorizeMessage2(login: String, password: String, p2: String) extends Message
