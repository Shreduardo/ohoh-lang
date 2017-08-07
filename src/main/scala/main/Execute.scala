package luccs.proglang.p3a.scala


import scala.util.{ Failure, Success, Try }

import MemTypes._



object Execute {

    def apply(store: Store, syntaxTree: Syntax): Cell = syntaxTree match {
        case Constant(value)  => Cell(value)
        case Plus(l, r)       => binaryOperation(apply(store, l), apply(store, r), _+_)
        case Minus(l, r)      => binaryOperation(apply(store, l), apply(store, r), _-_)
        case Mult(l, r)       => binaryOperation(apply(store, l), apply(store, r), _*_)
        case Div(l, r)        => binaryOperation(apply(store, l), apply(store, r), _/_)
        case Mod(l, r)        => binaryOperation(apply(store, l), apply(store, r), _%_)
        case Variable(x)      => store(x)
        // case Assignment(l, r) => {
        //     val left = apply(store, l)
        //     val right = apply(store, r)
        //     left.save(right.load)
        // }
        // case Sequence(statements @ _ *) => {
        //     statements.foldLeft(Cell.NULL)((cell, next) apply(store, next))
        // }
        // case Loop(guard, body) => {
        //     var guardCell = apply(store, guard)
        //     while(guardCell.load != 0)
        // }
        //case UMinus
        //case Mult(l, r) => Cell(apply(store, l).load * apply(store, r).load)
    }

    def binaryOperation(left: Cell, right: Cell, op: (Int, Int) => Int): Cell = {
        //for{ val Num(l) <- left.load; val Num(r) <- right.load } yield Cell(Num(op(l, r)))
        val Num(l) = left.load
        val Num(r) = right.load
        Cell(Num(op(l, r)))
    }
}
