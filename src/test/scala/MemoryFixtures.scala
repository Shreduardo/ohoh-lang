package luccs.proglang.p3a.scala

import behaviors._

object MemoryFixtures {

    import scala.collection.mutable.Map
    var store: Store = Map[String, Cell]()

    var c1 = Cell(1)
    var c2 = Cell(42)
    var c3 = Cell(138)
}
