package ca.jbrains.pos.test;

import ca.jbrains.pos.Price;

public class EnglishLanguageFormat {
    public String formatPrice(Price price) {
        return String.format("EUR %.2f", price.euro());
    }
}
