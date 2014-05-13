package me.fornever.nanorevolution.macros

import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context
import spray.json._

object Parsers {

  def impl(c: Context)(typeName: c.Expr[String], map: c.Expr[JsObject]): c.Expr[Message] = {
    import c.universe._

    val classes = Seq(typeOf[AuthorizeMessage1], typeOf[AuthorizeMessage2])
    val clauses = classes.map(c => {
      val literal = "A"
      cq"$literal => new $c()"
    })

    val tree = q"$typeName match { case ..$clauses }"
    c.Expr[Message](tree)
  }

  def createMessageM(typeName: String, map: JsObject): Message = macro Parsers.impl
}
