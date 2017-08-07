package luccs.proglang.p3a.scala

import scala.util.{ Failure, Success, Try }


object MemTypes {

    /* Memory Value types */
    sealed trait Value
    case class Num(value: Int) extends Value


    /* Mutable Memory Cells */
    case class Cell(var value: Value){
        def load: Value = value
        def save(value: Value): Unit = { this.value = value }
    }
    
    /* Concrete Cell object */
    object Cell {
        def apply(i: Int): Cell = Cell(Num(i))
        val NULL = Cell(0)
    }


    /* Main memory type alias */
    import scala.collection.mutable.Map
    type Instance = Map[String, Cell]
    type Store = Instance

    /* Error handling result type */
    type Result = Try[Cell]


    /* Function to retrieve objects in memory */
    def retrieve(store: Store, name: String): Result =
        store.get(name).fold {
            Failure(new NoSuchFieldException(name)): Result
        } {
            Success(_)
        }


}
