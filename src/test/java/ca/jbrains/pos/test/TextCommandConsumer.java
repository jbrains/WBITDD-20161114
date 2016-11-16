package ca.jbrains.pos.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class TextCommandConsumer {
    private final BarcodeScannedListener barcodeScannedListener;

    public TextCommandConsumer(BarcodeScannedListener barcodeScannedListener) {
        this.barcodeScannedListener = barcodeScannedListener;
    }

    public void consumeBarcodeCommands(StringReader commandSource) throws IOException {
        final String line = new BufferedReader(commandSource).readLine();
        if (line != null)
            barcodeScannedListener.onBarcode(line);
    }
}
