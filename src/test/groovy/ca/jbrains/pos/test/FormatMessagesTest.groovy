package ca.jbrains.pos.test

import spock.lang.Specification

class FormatMessagesTest extends Specification {
    def "empty barcode"() {
        given:
        def format = new EnglishLanguageMessageFormat()

        when:
        def messageText = format.formatScannedEmptyBarcodeMessage()

        then:
        "Scanning error: empty barcode" == messageText

    }
    def "barcode not found"() {
        given:
        def format = new EnglishLanguageMessageFormat()

        when:
        def messageText = format.formatProductNotFoundMessage("::barcode not found::")

        then:
        "Product not found for ::barcode not found::" == messageText
    }
}