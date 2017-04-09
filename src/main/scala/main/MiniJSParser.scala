package luccs.proglang.p3a.scala

import scala.util.parsing.combinator._ //{JavaTokenParsers, RegexParsers}

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
        // "{" ~> repeated <~ "}" ^^ {case r => r}
        // | "{" ~> expr <~ "}" ^^ {case e => e}
        // | "{" ~> loop <~ "}" ^^ {case b => b}
        // | "{" ~> assignment <~ "}" ^^ {case a => a}

        "{" ~> rep(statement) <~ "}" ^^ {case s => Sequence(s: _*)}
        | "{" ~> statement <~ "}" ^^ {case s => s}
    )

    /* TODO: add else constructs */
    // def conditional: Parser[Statement] = (
    //     "if" ~ "(" ~ expr ~ ")" ~ block ~ None ^^ { case g ~ _ ~ b => Condition(g, b, None)}
    //     | "if" ~ "(" ~ expr ~ ")" ~ block ~ "else" ~ block ^^ {case g ~ _ ~ b1 ~ _ ~ b2 => Condition(g, b1, Some(b2)) }
    // )

    /* TODO: add 'for' consturcts */
    def loop: Parser[Statement] = (
        "while" ~ "(" ~> expr ~ ")" ~ block ^^ { case g ~ _ ~ b => While(g, b)}
    )

    def assignment: Parser[Statement] = (
        ident ~ "=" ~ expr ^^ {case l ~ _ ~ r => Assignment(Variable(l), r)}
    )

}
