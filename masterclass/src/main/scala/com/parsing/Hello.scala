package com.parsing

import fastparse._, NoWhitespace._

object Hello {
  def number[_: P]: P[Int] = P(CharIn("0-9").rep(1).!.map(_.toInt))

  def parens[_: P]: P[Int] = P("(" ~/ addSub ~ ")")

  def factor[_: P]: P[Int] = P(number | parens)

  def divMul[_: P]: P[Int] = P(factor ~ (CharIn("*/").! ~/ factor).rep).map(eval)

  def addSub[_: P]: P[Int] = P(divMul ~ (CharIn("+\\-").! ~/ divMul).rep).map(eval)

  def expr[_: P]: P[Int] = P(addSub ~ End)

  def eval(tree: (Int, Seq[(String, Int)])) = {
    val (base, ops) = tree
    ops.foldLeft(base){ case (left, (op, right)) => op match{
      case "+" => left + right case "-" => left - right
      case "*" => left * right case "/" => left / right
    }}
  }

  val test: Parsed[Int] = parse("1+1", expr(_))
}