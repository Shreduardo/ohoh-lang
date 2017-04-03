package luccs.proglang.p3a.scala

import scala.util.parsing.combinator._ //{JavaTokenParsers, RegexParsers}

object MiniJSParser extends JavaTokenParsers with RegexParsers {


    def expr: Parser[Statement] = (
        term ~ "+" ~ term ^^ { case l ~ _ ~ r => Plus(l, r) }
        | term ~ "-" ~ term ^^ { case l ~ _ ~ r => Minus(l, r) }
        | term
        | factor
    )

    def term: Parser[Statement] = (
        factor ~ "*" ~ factor ^^ { case l ~ _ ~ r => Mult(l, r) }
        | factor ~ "/" ~ factor ^^ { case l ~ _ ~ r => Div(l, r) }
        | factor
    )

    def factor: Parser[Statement] = (
        wholeNumber ^^ { case s => Constant(s.toInt) }
        | ident ^^ { case s => Variable(s) }
        | "(" ~> expr <~ ")" ^^ { case e => e }
    )

    //Split these into three different combinators
      def statement: Parser[Statement] = (
          ident ~ "=" ~ expr ^^ { case s ~ _ ~ r => Assignment(Variable(s), r) }
          | "while" ~ "(" ~> expr ~ ")" ~ statement ^^ { case g ~ _ ~ b => While(g, b) }
          | "{" ~> repsep(statement, ",") <~ "}" ^^ { case ss => Sequence(ss: _*) }
      )

      def assignment: Parser[Statement] = (

      )

}
    // def expression: Parser[Statement] = term~rep("+"~term | "-"~term)
    // def term: Parser[Statement] = factor~rep("*"~factor | "/"~factor)
    // def factor: Parser[Statement] = identity | "("~expression~")"
    //
    // def identity: Parser[Statement] = """[a-zA-z] [a-zA-Z0-9]\w*""".r
    //
    // def statement: Parser[Statement] = expression~";" |
    //                                 assignment |
    //                                 conditional |
    //                                 loop |
    //                                 block
    //
    // def assignment: Parser[Statement] = ident~"="~expression~";"
    //
    // def conditional: Parser[Statement] = "if"~"("~expression~")"~block~"else"~block
    //
    // def loop: Parser[Statement] = "while"~"("~expression~")"~block
    //
    // def block: Parser[Statement] = "{"~rep(statement)~"}"
