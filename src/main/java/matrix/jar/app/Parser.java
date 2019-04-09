package matrix.jar.app;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.Map;

public class Parser {

    public static final Map parse(String[] args) {
        ArgumentParser parser =
                ArgumentParsers.newFor("matrix-jar-app").build()
                .defaultHelp(true)
                .description("Set matrixes size, module and if printing result.");
        parser.addArgument("-s", "--size")
                .help("Specify the size of the matrixes")
                .type(int.class)
                .required(true);
        parser.addArgument("-m", "--module")
                .help("Module to fill the matrixes")
                .type(int.class)
                .required(true);
        parser.addArgument("-p", "--print")
                .help("Print all matrixes")
                .setDefault(Arguments.storeFalse())
                .action(Arguments.storeTrue());
        parser.addArgument("-e", "--http-endpoint").
                help("HTTP endpoint to mark when fill and multiplication operations start and finish")
                .type(String.class);

        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }

        return ns.getAttrs();
    }
}
