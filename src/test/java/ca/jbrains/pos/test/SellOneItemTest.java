package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SellOneItemTest {
    @Test
    public void productFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "EUR 7.50");
            put("23456", "EUR 12.95");
        }});

        sale.onBarcode("12345");

        Assert.assertEquals("EUR 7.50", display.getText());
    }

    @Test
    public void anotherProductFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "EUR 7.50");
            put("23456", "EUR 12.95");
        }});

        sale.onBarcode("23456");

        Assert.assertEquals("EUR 12.95", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "EUR 7.50");
            put("23456", "EUR 12.95");
        }});

        sale.onBarcode("99999");

        Assert.assertEquals(
                "Product not found for 99999",
                display.getText()
        );
    }

    @Test
    public void emptyBarcode() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "EUR 7.50");
            put("23456", "EUR 12.95");
        }});

        sale.onBarcode("");

        Assert.assertEquals(
                "Scanning error: empty barcode",
                display.getText()
        );
    }

    public static class Sale {
        private final Map<String, String> pricesByBarcode;
        private Display display;

        public Sale(Display display, Map<String, String> pricesByBarcode) {
            this.display = display;
            this.pricesByBarcode = pricesByBarcode;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode)) {
                displayScannedEmptyBarcodeMessage();
                return;
            }

            if (pricesByBarcode.containsKey(barcode)) {
                displayPrice(findPrice(barcode));
            }
            else
                displayProductNotFoundMessage(barcode);
        }

        private void displayPrice(String priceAsText) {
            display.setText(priceAsText);
        }

        private void displayProductNotFoundMessage(String barcode) {
            display.setText(String.format("Product not found for %s", barcode));
        }

        private void displayScannedEmptyBarcodeMessage() {
            display.setText("Scanning error: empty barcode");
        }

        private String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
