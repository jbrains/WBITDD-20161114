package ca.jbrains.pos.test

import ca.jbrains.pos.PrintWriterCanvas
import spock.lang.Specification

// This test doesn't care what you're rendering!
// PrintWriterCanvas might be Too Simple to Break.
class RenderToPrintWriterTest extends Specification {
    def "happy path"() {
        expect:
        "::arbitrary text::" + System.lineSeparator() == render("::arbitrary text")
    }

    String render(String text) {
        def writer = new StringWriter()
        new PrintWriterCanvas(writer).render("::arbitrary text::");
        return writer.toString()
    }
}