package ca.jbrains.pos.test;

import java.io.PrintWriter;
import java.io.Writer;

public class PrintWriterCanvas implements Canvas {
    private PrintWriter out;

    public PrintWriterCanvas(Writer delegate) {
        // Important! We need to auto-flush the PrintWriter on println().
        // Read the documentation of this constructor for more details.
        this.out = new PrintWriter(delegate, true);
    }

    @Override
    public void render(String message) {
        out.println(message);
    }
}