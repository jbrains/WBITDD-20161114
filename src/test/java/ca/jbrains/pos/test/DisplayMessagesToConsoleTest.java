package ca.jbrains.pos.test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DisplayMessagesToConsoleTest {
    private PrintStream productionStdout;

    @Before
    public void rememberGlobals() throws Exception {
        productionStdout = System.out;
    }

    @After
    public void resetGlobals() throws Exception {
        System.setOut(productionStdout);
    }

    @Test
    public void emptyBarcode() throws Exception {
        final ByteArrayOutputStream canvas = new ByteArrayOutputStream(100);
        System.setOut(new PrintStream(canvas));

        new PrintWriterDisplay().displayScannedEmptyBarcodeMessage();

        final String displayText = canvas.toString("UTF-8").trim();
        Assert.assertEquals("Scanning error: empty barcode", displayText);
    }

    public static class PrintWriterDisplay implements Display {
        @Override
        public void displayPrice(Price price) {
        }

        @Override
        public void displayProductNotFoundMessage(String barcodeNotFound) {
        }

        @Override
        public void displayScannedEmptyBarcodeMessage() {
            System.out.println("Scanning error: empty barcode");
        }
    }
}
