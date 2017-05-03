package luccs.proglang.p3a.scala


import scala.util.{ Failure, Success, Try }

import MemTypes._



object Execute {



    // def apply(store: Store, s: Statement): lVal[Int] = s match {
    //     case Constant(value)   => Cell(value)
    //     case Plus(l, r) => Cell(apply(store, l).load + apply(store, r).load)
    //     case Minus(l, r) => Cell(apply(store, l).load - apply(store, r).load)
    //     case Mult(l, r) => Cell(apply(store, l).load * apply(store, r).load)
    //     case Div(l, r) => Cell(apply(store, l).load / apply(store, r).load)
    //     case Mod(l, r) => Cell(apply(store, l).load % apply(store, r).load)
    //     //case UMinus
    //     //case Mult(l, r) => Cell(apply(store, l).load * apply(store, r).load)
    // }

    def binOp(left: Cell, right: Cell, op: (Int, Int) => Int): Cell = {
        //for{ val Num(l) <- left.load; val Num(r) <- right.load } yield Cell(Num(op(l, r)))
        val Num(l) = left.load
        val Num(r) = right.load
        Cell(Num(op(l, r)))
    }
}
