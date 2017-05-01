package luccs.proglang.p3a.scala

import scala.util.parsing.combinator._ //JavaTokenParsers

object MiniJSParser extends JavaTokenParsers {

    def statement: Parser[Statement] = (
                                         loop |
                                         assignment|
                                         block |
                                         expr
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

    def term: Parser[Statement] = (
        factor ~ "*" ~ factor ^^ { case l ~ _ ~ r => Mult(l, r) }
        | factor ~ "/" ~ factor ^^ { case l ~ _ ~ r => Div(l, r) }
        | factor ~ "%" ~ factor ^^ { case l ~ _ ~ r => Mod(l, r) }
        | factor
    )

    def factor: Parser[Statement] = (
        wholeNumber ^^ { case s => Constant(s.toInt) }
        | "+" ~> factor ^^ { case e => e }
        | "-" ~> factor ^^ { case e => UMinus(e) }
        | ident ^^ { case s => Variable(s) }
        | "(" ~> expr <~ ")" ^^ { case e => e }
        | struct
    )

    def block: Parser[Statement] = (
        "{" ~> statement <~ "}" ^^ {case s => s}
        | "{" ~> rep(statement) <~ "}" ^^ { case r => Sequence(r.toArray: _*) }
    )

    def conditional: Parser[Statement] = (
        "if" ~ "(" ~ expr ~ ")" ~ block ^^ { case _ ~ _ ~ g ~ _ ~ b => Condition(g, b, Void) }
        | "if" ~ "(" ~ expr ~ ")" ~ block ~ "else" ~ block ^^ {case _ ~ _ ~ g ~ _ ~  b1 ~ _ ~ b2 => Condition(g, b1, b2) }
    )

    /* TODO: add 'for' consturcts */
    def loop: Parser[Statement] = (
        "while" ~ "(" ~> expr ~ ")" ~ block ^^ { case g ~ _ ~ b => Loop(g, b)}
    )

    def assignment: Parser[Statement] = (
        ident ~ "=" ~ expr ^^ {case l ~ _ ~ r => Assignment(Variable(l), r)}
    )

    def struct: Parser[Statement] = (
        "{" ~ "}" ^^ { case _ => Struct() }
        | "{" ~> repsep(field, ",") <~ "}" ^^ { case f => Struct(f: _*) }  //repsep as shortcut for "," ?
    )

    def field: Parser[Statement] = (
        ident ~ ":" ~ expr ^^ {case i ~ _ ~ e => Field(i, e)}
    )

}
