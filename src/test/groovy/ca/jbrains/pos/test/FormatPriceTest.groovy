package ca.jbrains.pos.test

import ca.jbrains.pos.Price
import spock.lang.Specification
import spock.lang.Unroll

class FormatPriceTest extends Specification {
    @Unroll
    def "format price of #price.centsValue cents"() {
        expect:
        displayText == formatPrice(price)

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

    def formatPrice(def price) {
        return new EnglishLanguageFormat().formatPrice(price)
    }
}
