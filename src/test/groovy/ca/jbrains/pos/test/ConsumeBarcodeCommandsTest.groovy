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
        0 * barcodeScannedListener._(*_)
    }

    def "several"() {
        given:
        BarcodeScannedListener barcodeScannedListener = Mock(BarcodeScannedListener)

        when:
        consumeCommands(barcodeScannedListener, """::barcode 0::
::barcode 1::
::barcode 2::
::barcode 3::
::barcode 4::
""")

        then:
        1 * barcodeScannedListener.onBarcode("::barcode 0::")
        1 * barcodeScannedListener.onBarcode("::barcode 1::")
        1 * barcodeScannedListener.onBarcode("::barcode 2::")
        1 * barcodeScannedListener.onBarcode("::barcode 3::")
        1 * barcodeScannedListener.onBarcode("::barcode 4::")
    }

    def "empty"() {
        given:
        BarcodeScannedListener barcodeScannedListener = Mock(BarcodeScannedListener)

        when:
        consumeCommands(barcodeScannedListener, """
\t    \r
       \f
    \n
""")

        then:
        0 * barcodeScannedListener._(*_)
    }
}
