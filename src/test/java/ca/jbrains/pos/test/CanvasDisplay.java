package ca.jbrains.pos.test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;

// REFACTOR This class just composes two actions!
// Surely we can eliminate it somehow...
public class CanvasDisplay implements Display {
    private final Canvas canvas;
    private final MessageFormat messageFormat;

    public CanvasDisplay(Canvas canvas, MessageFormat messageFormat) {
        this.canvas = canvas;
        this.messageFormat = messageFormat;
    }

    @Override
    public void displayPrice(Price price) {
        canvas.render(messageFormat.formatPrice(price));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        canvas.render(messageFormat.formatProductNotFoundMessage(barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
        canvas.render(messageFormat.formatScannedEmptyBarcodeMessage());
    }
}
