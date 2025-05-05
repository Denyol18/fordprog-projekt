import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Input helye:
        String input = """
        polynom a, b;
        number y;
        y = 2;
        a = <y x^3 + 2.5x^2 - 10x + 2>;
        b = <x^5 + y x - 30>;
        show a[1] + b[3];
        show (a[1] + a[1])/a[2];
        show(<x^2 + 2x + 1> / <1x^1 + 1>)[a[b[y]]];
        """;

        CharStream charStream = CharStreams.fromString(input);
        PolynomialLexer lexer = new PolynomialLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PolynomialParser parser = new PolynomialParser(tokens);

        ParseTree tree = parser.program();
        EvalVisitor visitor = new EvalVisitor();   // Custom visitorunk példányosítása.
        visitor.visit(tree);   // Parse tree bejárás megkezdése.
    }
}