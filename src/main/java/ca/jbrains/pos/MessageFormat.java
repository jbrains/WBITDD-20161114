package ca.jbrains.pos;

import ca.jbrains.pos.Price;

public interface MessageFormat {
    String formatScannedEmptyBarcodeMessage();

    String formatProductNotFoundMessage(String barcodeNotFound);

    String formatPrice(Price price);
}
