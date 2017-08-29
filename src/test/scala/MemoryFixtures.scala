package shredev.ohohlang.scala

import MemTypes._

object MemoryFixtures {

    /** Non-error handling **/
    import scala.collection.mutable.Map
    var store: Store = Map[String, Cell]()

    var c1 = Cell(1)
    var c2 = Cell(42)
    var c3 = Cell(126)
    var c4 = Cell(130)
}
