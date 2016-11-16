package ca.jbrains.pos.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.stream.Stream;

class TextCommandConsumer {
    private final BarcodeScannedListener barcodeScannedListener;

    public TextCommandConsumer(BarcodeScannedListener barcodeScannedListener) {
        this.barcodeScannedListener = barcodeScannedListener;
    }

    public void consumeBarcodeCommands(Reader commandSource) {
        sanitizeCommandStream(commandStream(commandSource))
                .forEach(barcodeScannedListener::onBarcode);
    }

    private Stream<String> sanitizeCommandStream(Stream<String> commandStream) {
        return commandStream
                .map(String::trim)
                .filter((line) -> !line.isEmpty());
    }

    private Stream<String> commandStream(Reader commandSource) {
        return new BufferedReader(commandSource).lines();
    }
}
