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
        new CanvasDisplay().displayPrice(price)

        then:
        displayText == canvas.toString("UTF-8").trim()

        where:
        price                  || displayText
        Price.cents(175)       || "EUR 1.75"
        Price.cents(230)       || "EUR 2.30"
        Price.cents(0)         || "EUR 0.00"
        Price.cents(1)         || "EUR 0.01"
        Price.cents(10)        || "EUR 0.10"
        Price.cents(99)        || "EUR 0.99"
        Price.cents(1000)      || "EUR 10.00"
        Price.cents(23746)     || "EUR 237.46"
        Price.cents(234743341) || "EUR 2347433.41"
    }
}
