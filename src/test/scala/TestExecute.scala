//
// package luccs.proglang.p3a.scala
//
// import org.scalatest.FunSuite
//
// import MemTypes._
// import Execute._
// import MemoryFixtures._
// import TestFixtures._
//
// class TestExecute extends FunSuite {
//
//     /* Binary Operations Testing */
//     test("Plus Binary Op") { assert ( binOp(c2, c3, _+_) === Cell(168) ) }
//     test("Minus Binary Op") { assert ( binOp(c4, c3, _-_) === Cell(4) ) }
//     test("Div Binary Op") { assert ( binOp(c3, c2, _/_) === Cell(3) ) }
//     test("Mult Binary Op") { assert ( binOp(c2, c3, _*_) === Cell(5292) ) }
//     test("Mod Binary Op") { assert ( binOp(c4, c2, _%_) === Cell(4) ) }
//
//     /* Execution on Statement Testing */
//     test("Basic Execute") {
//         assert(Execute(store, basicExpression) === Cell(3))
//     }
//
//     test("Simple Execute") {
//         assert(Execute(store, simpleExpression) === Cell(2))
//     }
//
//
// }
