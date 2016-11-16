package ca.jbrains.pos.test

import ca.jbrains.pos.Price
import spock.lang.Specification
import spock.lang.Unroll

class DisplayPriceToConsoleTest extends Specification {
    @Unroll
    def "display price of #price.centsValue cents"() {
        given:
        Canvas canvas = Mock(Canvas)

        when:
        // SMELL Why would we go through the CanvasDisplay,
        // when we really want to check the results of
        // EnglishLanguageMessageFormat directly?
        new CanvasDisplay(canvas, new EnglishLanguageMessageFormat()).displayPrice(price)

        then:
        1 * canvas.render(displayText)

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
