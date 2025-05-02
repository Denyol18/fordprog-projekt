import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = """
        polynom a, b, c;
        a = <x - 1>;
        b = <x + 1x^0>;
        c = <2x +2x>;
        show(2+2*b);
        """;

        CharStream charStream = CharStreams.fromString(input);
        PolynomialLexer lexer = new PolynomialLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PolynomialParser parser = new PolynomialParser(tokens);

        ParseTree tree = parser.program();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}