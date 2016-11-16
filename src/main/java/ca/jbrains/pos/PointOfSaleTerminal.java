package ca.jbrains.pos;


import java.io.OutputStreamWriter;
import java.util.HashMap;

public class PointOfSaleTerminal {
    public static void main(String[] args) {
        final SellOneItemController controller = new SellOneItemController(
                new InMemoryCatalog(
                        new HashMap<String, Price>() {{
                            put("7070529026686", Price.cents(125));
                        }}
                ),
                new CanvasDisplay(
                        new PrintWriterCanvas(
                                new OutputStreamWriter(System.out)
                        ),
                        new EnglishLanguageMessageFormat()
                )
        );
        controller.onBarcode("12345");
        controller.onBarcode("23456");
        controller.onBarcode("99999");
        controller.onBarcode("7070529026686");
    }
}
