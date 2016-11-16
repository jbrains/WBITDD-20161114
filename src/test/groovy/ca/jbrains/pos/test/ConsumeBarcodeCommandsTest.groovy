package ca.jbrains.pos.test

import spock.lang.Specification


class ConsumeBarcodeCommandsTest extends Specification {
    def "one"() {
        given:
        BarcodeScannedListener barcodeScannedListener = Mock(BarcodeScannedListener)
        when:
        consumeCommands(barcodeScannedListener, "::barcode::\n")

        then:
        1 * barcodeScannedListener.onBarcode("::barcode::")
    }

    private consumeCommands(BarcodeScannedListener barcodeScannedListener, String commandScript) {
        new TextCommandConsumer(barcodeScannedListener).consumeBarcodeCommands(new StringReader(commandScript))
    }

    def "none"() {
        given:
        BarcodeScannedListener barcodeScannedListener = Mock(BarcodeScannedListener)

        when:
        consumeCommands(barcodeScannedListener, "")

        then:
        0 * barcodeScannedListener.onBarcode(_)
    }
}