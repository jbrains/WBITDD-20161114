package ca.jbrains.pos.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DisplayMessagesToConsoleTest {
    private PrintStream productionStdout;
    private ByteArrayOutputStream canvas;

    @Before
    public void substituteStdout() throws Exception {
        productionStdout = System.out;
        canvas = new ByteArrayOutputStream(100);
        System.setOut(new PrintStream(canvas));
    }

    @After
    public void resetStdout() throws Exception {
        System.setOut(productionStdout);
    }

    @Test
    public void emptyBarcode() throws Exception {
        new CanvasDisplay(new StandardOutCanvas(), new EnglishLanguageMessageFormat()).displayScannedEmptyBarcodeMessage();

        final String displayText = canvas.toString("UTF-8").trim();
        Assert.assertEquals("Scanning error: empty barcode", displayText);
    }

    @Test
    public void productNotFound() throws Exception {
        new CanvasDisplay(new StandardOutCanvas(), new EnglishLanguageMessageFormat()).displayProductNotFoundMessage("23476123782364");

        final String displayText = canvas.toString("UTF-8").trim();
        Assert.assertEquals("Product not found for 23476123782364", displayText);
    }
}
