package luccs.proglang.p3a.scala

import scala.util.parsing.combinator._ //JavaTokenParsers

object MiniJSParser extends JavaTokenParsers {

    def statement: Parser[Statement] = (
                                         loop |
                                         assignment|
                                         block |
                                         expr |
                                         term |
                                         factor
                                       )

    def repeated: Parser[Statement] = (
        rep(statement) ^^ { case s => Sequence(s: _*) }
    )

    /* TODO: Add support for >, < consturcts */
    def expr: Parser[Statement] = (
        term ~ "+" ~ term ^^ { case l ~ _ ~ r => Plus(l, r) }
        | term ~ "-" ~ term ^^ { case l ~ _ ~ r => Minus(l, r) }
        | term
        | factor
    )

    /* TODO: Add support for % constructs */
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

    def block: Parser[Statement] = (
        "{" ~> statement <~ "}" ^^ {case s => s}
        | "{" ~> rep(statement) <~ "}" ^^ { case r => Sequence(r: _*) }
    )


    /* TODO: add else constructs */
    def conditional: Parser[Statement] = (
        "if" ~ "(" ~ expr ~ ")" ~ block ^^ { case _ ~ _ ~ g ~ _ ~ b => Condition(g, b, None)}
        | "if" ~ "(" ~ expr ~ ")" ~ block ~ "else" ~ block ^^ {case _ ~ _ ~ g ~ _ ~  b1 ~ _ ~ b2 => Condition(g, b1, Some(b2)) }
    )

    /* TODO: add 'for' consturcts */
    def loop: Parser[Statement] = (
        "while" ~ "(" ~> expr ~ ")" ~ block ^^ { case g ~ _ ~ b => While(g, b)}
    )

    def assignment: Parser[Statement] = (
        ident ~ "=" ~ expr ^^ {case l ~ _ ~ r => Assignment(Variable(l), r)}
    )

}
