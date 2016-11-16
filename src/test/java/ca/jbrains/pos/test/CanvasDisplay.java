package ca.jbrains.pos.test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;

public class CanvasDisplay implements Display {
    private final StandardOutCanvas standardOutCanvas;
    private final EnglishLanguageFormat englishLanguageFormat;

    public CanvasDisplay(StandardOutCanvas standardOutCanvas, EnglishLanguageFormat messageFormat) {
        this.standardOutCanvas = standardOutCanvas;
        englishLanguageFormat = messageFormat;
    }

    @Override
    public void displayPrice(Price price) {
        standardOutCanvas.render(englishLanguageFormat.formatPrice(price));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        standardOutCanvas.render(englishLanguageFormat.formatProductNotFoundMessage(barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
        standardOutCanvas.render(englishLanguageFormat.formatScannedEmptyBarcodeMessage());
    }
}
