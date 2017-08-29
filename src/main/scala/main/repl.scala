package shredev.ohohlang.scala

import MemTypes._
import Execute._
import OHOHParser._

object REPL extends App {

    import scala.collection.mutable.Map
    var store: Store = Map[String, Cell]()

    /* TODO: Error handling */
    def processInput(input: String): Syntax = {
        val result = OHOHParser.parseAll(OHOHParser.syntax, input)
        result.get
    }

    if (args.length > 0){
        processInput(args mkString " ")
    } else {
        print("osh >>> ")
        scala.io.Source.stdin.getLines foreach { line => {
                if (line == "q!"){
                    sys.exit
                }

                val parsedStatement = processInput(line)

                /* TODO: Handle Some() and None output */
                println("EVAL: ")
                println(Execute(store, parsedStatement))
                print("osh >>> ")
            }
        }
    }

    def welcome(): String = {
        val welcome = "                                        " +
                      "       ___________      ___________     " +
                      "      /   ___    /|    /   ___    /|    " +
                      "     /   /  /   / /   /   /  /   / /    " +
                      "    /   /  /   / /   /   /  /   / /     " +
                      "   /   /__/   / /   /   /__/   / /      " +
                      "  /__________/ /   /__________/ /       " +
                      "  |__________|/    |__________|/        " +
                      "                                        " +
                      "                                        "
        return welcome
    }
}
