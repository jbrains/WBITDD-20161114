package ca.jbrains.pos.test

import ca.jbrains.pos.Price
import spock.lang.Specification
import spock.lang.Unroll

class DisplayPriceToConsoleTest extends Specification {
    PrintStream productionStdout

    def setup() {
        productionStdout = System.out
    }

    def cleanup() {
        System.setOut(productionStdout)
    }

    @Unroll
    def "display price of #price.centsValue cents"() {
        def canvas = new ByteArrayOutputStream()

        given:
        System.setOut(new PrintStream(canvas))

        when:
        new PrintWriterDisplay().displayPrice(price)

        then:
        displayText == canvas.toString("UTF-8").trim()

        where:
        price            || displayText
        Price.cents(175) || "EUR 1.75"
    }
}
