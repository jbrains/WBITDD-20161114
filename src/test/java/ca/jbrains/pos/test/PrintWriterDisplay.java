package ca.jbrains.pos.test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;

public class PrintWriterDisplay implements Display {

    private EnglishLanguageFormat englishLanguageFormat
            = new EnglishLanguageFormat();

    @Override
    public void displayPrice(Price price) {
        render(englishLanguageFormat.formatPrice(price));
    }

    private void render(String message) {
        System.out.println(message);
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        render(englishLanguageFormat.formatProductNotFoundMessage(barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
        render(englishLanguageFormat.formatScannedEmptyBarcodeMessage());
    }

}
