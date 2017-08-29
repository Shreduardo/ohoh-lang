package shredev.ohohlang.scala


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
        case Variable(x)      => { Cell.NULL
            // if(store.contains(x)){
            //     return Cell(store.get(x))
            // }
            // else{
            //     store(x) = NULL
            //     return Cell.NULL
            // }
        }

        /* TODO: Get rid of Some() in print out */
        case Assignment(l, r) => {
            // l is a Variable type
            // Store the variable by name with apply
            apply(store, l)
            // Create right value by recursively applying
            val right = apply(store, r)
            // Update the value of l in store
            store(l.name) = right
            // Return null Cell
            right
        }
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
