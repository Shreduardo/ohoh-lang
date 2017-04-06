package luccs.proglang.p3a.scala

import scala.util.parsing.combinator._ //{JavaTokenParsers, RegexParsers}

object MiniJSParser extends JavaTokenParsers {


    // def statement: Parser[Statement] = (
    //     ident ~ "=" ~ expr ^^ { case s ~ _ ~ r => Assignment(Variable(s), r) }
    //     | "while" ~ "(" ~> expr ~ ")" ~ statement ^^ { case C ~ _ ~ b => While(c, b) }
    //     | "{" ~> repsep(statement, ",") <~ "}" ^^ { case ss => Sequence(ss: _*) }
    // )

    def statement: Parser[Statement] = ( expr |
                                         term |
                                         factor |
                                         block |
                                         loop |
                                         assignment
                                       )

    //TODO: Add support for >, < consturcts
    //     expr + erm = operator??
    def expr: Parser[Statement] = (
        term ~ "+" ~ term ^^ { case l ~ _ ~ r => Plus(l, r) }
        | term ~ "-" ~ term ^^ { case l ~ _ ~ r => Minus(l, r) }
        | term
        | factor
        | repsep(expr, " ")
    )

    //TODO: Add support for % constructs
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
        "{" ~> repsep(statement, " ") <~ "}" ^^ {case ss => Sequence(ss: _*)}
    )

    //TODO: add else constructs
    def conditional: Parser[Statement] = (
        "if" ~ "(" ~> expr ~ ")" ~ block ^^ { case g ~ _ ~ b => Condition(g, b)}
    )

    //TODO: add 'for' consturcts
    def loop: Parser[Statement] = (
        "while" ~ "(" ~> expr ~ ")" ~ block ^^ { case g ~ _ ~ b => While(g, b)}
    )

    def assignment: Parser[Statement] = (
        ident ~ "=" ~ expr ^^ {case s ~ _ ~ r => Assignment(Variable(s), r)}
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
