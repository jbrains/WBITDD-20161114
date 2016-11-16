package ca.jbrains.pos.test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;

public class PrintWriterDisplay implements Display {
    @Override
    public void displayPrice(Price price) {
        System.out.println(new EnglishLanguageFormat().formatPrice(price));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        System.out.println(new EnglishLanguageFormat().formatProductNotFoundMessage(barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
        System.out.println("Scanning error: empty barcode");
    }
}
