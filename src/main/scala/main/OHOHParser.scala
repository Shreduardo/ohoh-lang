package shredev.ohohlang.scala

import scala.util.parsing.combinator._ //JavaTokenParsers

object OHOHParser extends JavaTokenParsers {

    def syntax: Parser[Syntax] = (
                                    loop |
                                    assignment|
                                    block |
                                    expr
                                )

    def repeated: Parser[Syntax] = (
        rep(syntax) ^^ { case s => Sequence(s: _*) }
    )

    /* TODO: Add support for >, < consturcts */
    def expr: Parser[Expression] = (
        term ~ "+" ~ term ^^ { case l ~ _ ~ r => Plus(l, r) }
        | term ~ "-" ~ term ^^ { case l ~ _ ~ r => Minus(l, r) }
        | term
        | factor
    )

    def term: Parser[Expression] = (
        factor ~ "*" ~ factor ^^ { case l ~ _ ~ r => Mult(l, r) }
        | factor ~ "/" ~ factor ^^ { case l ~ _ ~ r => Div(l, r) }
        | factor ~ "%" ~ factor ^^ { case l ~ _ ~ r => Mod(l, r) }
        | factor
    )

    def factor: Parser[Expression] = (
        wholeNumber ^^ { case s => Constant(s.toInt) }
        | "+" ~> factor ^^ { case e => e }
        | "-" ~> factor ^^ { case e => UMinus(e) }
        | ident ^^ { case s => Variable(s) }
        | "(" ~> expr <~ ")" ^^ { case e => e }
    )

    /* TODO: Handle execution before/after a block */
    def block: Parser[Syntax] = (
        "{" ~> syntax <~ "}" ^^ {case s => s}
        | "{" ~> rep(syntax) <~ "}" ^^ { case r => Sequence(r.toArray: _*) }
    )

    def conditional: Parser[Syntax] = (
        "if" ~ "(" ~ expr ~ ")" ~ block ~ "else" ~ block ^^ {case _ ~ _ ~ g ~ _ ~  b1 ~ _ ~ b2 => Condition(g, b1, b2) }
        | "if" ~ "(" ~ expr ~ ")" ~ block ^^ { case _ ~ _ ~ g ~ _ ~ b => Condition(g, b, Void) }
    )

    /* TODO: add 'for' consturcts */
    def loop: Parser[Syntax] = (
        "while" ~ "(" ~> expr ~ ")" ~ block ^^ { case g ~ _ ~ b => Loop(g, b)}
    )

    def assignment: Parser[Syntax] = (
        ident ~ "=" ~ expr ^^ {case l ~ _ ~ r => Assignment(Variable(l), r)}
    )


    def struct: Parser[Syntax] = (
        "{" ~ "}" ^^ { case _ => Struct() }
        | "{" ~> repsep(field, ",") <~ "}" ^^ { case f => Struct(f: _*) }
    )

    def field: Parser[Field] = (
        ident ~ ":" ~ expr ^^ {case i ~ _ ~ e => Field(i, e)}
    )

}
