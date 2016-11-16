package ca.jbrains.pos.test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;

public class CanvasDisplay implements Display {
    private final Canvas canvas = new Canvas();
    private final EnglishLanguageFormat englishLanguageFormat
            = new EnglishLanguageFormat();

    @Override
    public void displayPrice(Price price) {
        canvas.render(englishLanguageFormat.formatPrice(price));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        canvas.render(englishLanguageFormat.formatProductNotFoundMessage(barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
        canvas.render(englishLanguageFormat.formatScannedEmptyBarcodeMessage());
    }
}
