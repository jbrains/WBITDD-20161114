package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Test;

public class CreateFractionsTest {
    @Test
    public void rejectZeroDenominator() throws Exception {
        try {
            new AddFractionsTest.Fraction(7, 0);
            Assert.fail("How did you create a Fraction with a 0 denominator?!");
        } catch (IllegalArgumentException expected) {
        }
    }
}
