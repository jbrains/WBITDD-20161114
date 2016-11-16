package ca.jbrains.pos.test

import spock.lang.Specification


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