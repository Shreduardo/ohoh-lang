package luccs.proglang.p3a.scala

import scala.util.{ Failure, Success, Try }

object behaviors {

    /* Memory Cell Class */
    case class Cell(var value: Value){
        def load: Value = value
        def save(value: Value): Unit = this.value = value
    }

    /* Concrete Cell object */
    object Cell {
        def apply(i: Int):Cell = Cell(Num(i))
        val NULL = Cell(0)
    }

    /* Memory mapping */
    import scala.collection.mutable.Map
    type Instance = Map[String, Cell]

    /* Memory Store */
    type Store = Instance


    /* Evaluation return types */
    sealed trait Value
    case class Num(value: Int) extends Value

    type Result = Try[Cell]

    /* Memory element retreival */
    def retreive(store: Store, name: String): Result =
        store.get(name).fold {
            Failure(new NoSuchFieldException(name)): Result
        } {
            Success(_)
        }

    //Return type Result??
    // def evaluate(store: Store, s: Statement): Result = s match {
    //     case Constant(c)       => Success(Cell(Num(c)))
    //
    //     case UMinus(r)         => { for { Cell(Num(r)) <- evaluate(r) } yield Cell(Num(-r)) }
    //     case Plus(l, r)        => evaluate(store, l) + evaluate(store, r)
    //     case Minus(l, r)       => evaluate(store, l) - evaluate(store, r)
    //     case Mult(l, r)        => evaluate(store, l) * evaluate(store, r)
    //     case Div(l, r)         => evaluate(store, l) / evaluate(store,r)
    //     case Mod(l, r)         => evaluate(store, l) % evaluate(store, r)
    //
    //     case Variable(name)    => retreive(store, name)
    // }

    // def binaryOp(l, r, op:(Int, Int) => Int): Result = {
    //
    //     Cell(Num(op(l, r)))
    // }

}
