package ca.jbrains.pos.test;

import ca.jbrains.pos.Price;

public interface MessageFormat {
    String formatScannedEmptyBarcodeMessage();

    String formatProductNotFoundMessage(String barcodeNotFound);

    String formatPrice(Price price);
}
