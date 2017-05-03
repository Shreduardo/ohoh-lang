package luccs.proglang.p3a.scala

import MemTypes._
import Execute._

object REPL extends App {

    //var store: Store = Map[String, lVal[Int]]()
    /* TODO: Error handling */
    def processInput(input: String): Statement = {
        val result = MiniJSParser.parseAll(MiniJSParser.statement, input)
        result.get
    }

    if (args.length > 0){
        processInput(args mkString " ")
    } else {
        print("Enter infix expression: ")
        scala.io.Source.stdin.getLines foreach { line => {
                val parsedStatement = processInput(line)

                /*Evaluation output*/
                println("The parsed expression------ ")
                println(Formatter.toFormattedString(parsedStatement) + "\n")

                /* TODO: Unparsed/pretty print */
                println("The unparsed expression------")
                println("TODO...  \n")

                /* TODO: Evaluator (3b) */
                println("The evaluated expression------")
                println("TODO...  \n")

                print("Enter infix expression: ")
            }
        }
    }
}
