package ca.jbrains.pos.test

import spock.lang.Specification
import spock.lang.Unroll

class FormatMessagesTest extends Specification {
    @Unroll
    def "format #message"() {
        given:
        def format = new EnglishLanguageMessageFormat()

        expect:
        messageText == action(format)

        where:
        message             | action                                                                        || messageText
        "empty barcode"     | { MessageFormat f -> f.formatScannedEmptyBarcodeMessage() }                   || "Scanning error: empty barcode"
        "product not found" | { MessageFormat f -> f.formatProductNotFoundMessage("::barcode not found::")} || "Product not found for ::barcode not found::"
    }
}