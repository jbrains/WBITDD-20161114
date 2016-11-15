package ca.jbrains.pos.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindPriceInMemoryCatalogTest extends FindPriceInCatalogContract {

    @Override
    protected Catalog catalogWith(String barcode, Price matchingPrice) {
        return new InMemoryCatalog(new HashMap() {{
            put(String.format("Not %s", barcode), Price.cents(1));
            put(barcode, matchingPrice);
            put(String.format("Absolutely not %s", barcode), Price.cents(3));
        }});
    }

    @Override
    protected Catalog catalogWithout(String barcodeToAvoid) {
        return new InMemoryCatalog(new HashMap() {{
            put(String.format("Not %s", barcodeToAvoid), Price.cents(1));
            put(String.format("Certainly not %s", barcodeToAvoid), Price.cents(2));
            put(String.format("Absolutely not %s", barcodeToAvoid), Price.cents(3));
        }});
    }

    public static class InMemoryCatalog implements Catalog {
        private final Map<String, Price> pricesByBarcode;

        public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Price findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
