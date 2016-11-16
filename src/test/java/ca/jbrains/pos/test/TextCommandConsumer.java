package ca.jbrains.pos.test;

import java.io.StringReader;

class TextCommandConsumer {
    private final BarcodeScannedListener barcodeScannedListener;

    public TextCommandConsumer(BarcodeScannedListener barcodeScannedListener) {
        this.barcodeScannedListener = barcodeScannedListener;
    }

    public void consumeBarcodeCommands(StringReader commandSource) {
        barcodeScannedListener.onBarcode("::barcode::");
    }
}
