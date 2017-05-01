package luccs.proglang.p3a.scala

import org.scalatest.FunSuite
import scala.util.{ Failure, Success, Try }

import TestFixtures._
import MemoryFixtures._
import behaviors._

class TestBehaviors extends FunSuite {

    /* Memory Map and Store tests */
    test("Cell Update") {
        c1.save(Num(2))
        assert (c1.load === Num(2))
    }

    test("Store Update") {
        store("c1") = c1
        assert( store.get("c1") === Some(c1))
    }

    test("Store Retreive") {
        store("c2") = c2
        assert( retreive(store, "c2") === Success(c2) )
    }
    
}
