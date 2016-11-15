package ca.jbrains.pos.test;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class SellOneItemControllerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void productFound() throws Exception {
        final Catalog catalog = context.mock(Catalog.class);
        final Display display = context.mock(Display.class);
        final Price foundPrice = Price.cents(795);

        context.checking(new Expectations() {{
            allowing(catalog).findPrice(with("12345"));
            will(returnValue(foundPrice));

            oneOf(display).displayPrice(with(foundPrice));
        }});

        final SellOneItemController controller = new SellOneItemController(catalog, display);
        controller.onBarcode("12345");
    }

    @Test
    public void productNotFound() throws Exception {
        final Catalog catalog = context.mock(Catalog.class);
        final Display display = context.mock(Display.class);

        context.checking(new Expectations() {{
            allowing(catalog).findPrice(with("::barcode not found::"));
            will(returnValue(null));

            oneOf(display).displayProductNotFoundMessage(with("::barcode not found::"));
        }});

        final SellOneItemController controller = new SellOneItemController(catalog, display);
        controller.onBarcode("::barcode not found::");
    }

    public interface Catalog {
        Price findPrice(String barcode);
    }

    public interface Display {
        void displayPrice(Price price);

        void displayProductNotFoundMessage(String barcodeNotFound);
    }

    public static class SellOneItemController {
        private final Catalog catalog;
        private final Display display;

        public SellOneItemController(Catalog catalog, Display display) {
            this.catalog = catalog;
            this.display = display;
        }

        public void onBarcode(String barcode) {
            final Price price = catalog.findPrice(barcode);
            if (price == null)
                display.displayProductNotFoundMessage(barcode);
            else
                display.displayPrice(price);
        }
    }

    public static class Price {
        public static Price cents(int centsValue) {
            return new Price();
        }

        @Override
        public String toString() {
            return "a Price";
        }
    }
}
