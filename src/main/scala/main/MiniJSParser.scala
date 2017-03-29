package luccs.proglang.p3a.scala

import scala.util.parsing.combinator._ //{JavaTokenParsers, RegexParsers}

object MiniJSParser extends JavaTokenParsers with RegexParsers {

    def expression: Parser[Any] = term~rep("+"~term | "-"~term)
    def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
    def factor: Parser[Any] = identity | "("~expression~")"

    def identity: Parser[Any] = """[a-zA-z] [a-zA-Z0-9]\w*""".r

    def statement: Parser[Any] = expression~";" |
                                    assignment |
                                    conditional |
                                    loop |
                                    block

    def assignment: Parser[Any] = ident~"="~expression~";"

    def conditional: Parser[Any] = "if"~"("~expression~")"~block~"else"~block

    def loop: Parser[Any] = "while"~"("~expression~")"~block

    def block: Parser[Any] = "{"~rep(statement)~"}"


}
