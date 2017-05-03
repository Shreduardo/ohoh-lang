package luccs.proglang.p3a.scala


import scala.util.{ Failure, Success, Try }

import MemTypes._



object Execute {



    def apply(store: Store, s: Statement): Cell = s match {
        case Constant(value) => Cell(value)
        case Plus(l, r)      => binOp(apply(store, l), apply(store, r), _+_)
        case Minus(l, r)     => binOp(apply(store, l), apply(store, r), _-_)
        case Mult(l, r)      => binOp(apply(store, l), apply(store, r), _*_)
        case Div(l, r)       => binOp(apply(store, l), apply(store, r), _/_)
        case Mod(l, r)       => binOp(apply(store, l), apply(store, r), _%_)
        //case UMinus
        //case Mult(l, r) => Cell(apply(store, l).load * apply(store, r).load)
    }

    def binOp(left: Cell, right: Cell, op: (Int, Int) => Int): Cell = {
        //for{ val Num(l) <- left.load; val Num(r) <- right.load } yield Cell(Num(op(l, r)))
        val Num(l) = left.load
        val Num(r) = right.load
        Cell(Num(op(l, r)))
    }
}
