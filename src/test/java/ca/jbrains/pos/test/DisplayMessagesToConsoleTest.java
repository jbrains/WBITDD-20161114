package ca.jbrains.pos.test;

import ca.jbrains.pos.CanvasDisplay;
import ca.jbrains.pos.EnglishLanguageMessageFormat;
import ca.jbrains.pos.PrintWriterCanvas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class DisplayMessagesToConsoleTest {
    private ByteArrayOutputStream canvas;
    private CanvasDisplay display;

    @Before
    public void substituteStdout() throws Exception {
        canvas = new ByteArrayOutputStream(100);
        display = new CanvasDisplay(
                new PrintWriterCanvas(
                        new OutputStreamWriter(canvas)), new EnglishLanguageMessageFormat());
    }

    @Test
    public void emptyBarcode() throws Exception {
        display.displayScannedEmptyBarcodeMessage();

        final String displayText = canvas.toString("UTF-8").trim();
        Assert.assertEquals("Scanning error: empty barcode", displayText);
    }

    @Test
    public void productNotFound() throws Exception {
        display.displayProductNotFoundMessage("23476123782364");

        final String displayText = canvas.toString("UTF-8").trim();
        Assert.assertEquals("Product not found for 23476123782364", displayText);
    }
}
