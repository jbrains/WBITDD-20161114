package ca.jbrains.pos.test

import spock.lang.Specification


class ConsumeBarcodeCommandsTest extends Specification {
    BarcodeScannedListener barcodeScannedListener

    def "one"() {
        given:
        barcodeScannedListener = Mock(BarcodeScannedListener)

        when:
        new TextCommandConsumer(barcodeScannedListener).consumeBarcodeCommands(new StringReader("::barcode::\n"))

        then:
        1 * barcodeScannedListener.onBarcode("::barcode::")
    }
}