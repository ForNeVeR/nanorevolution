package me.fornever.nanorevolution.macros

abstract sealed class Message()

case class AuthorizeMessage1() extends Message()
case class AuthorizeMessage2() extends Message()
