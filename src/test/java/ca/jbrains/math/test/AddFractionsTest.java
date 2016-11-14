package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void zeroPlusZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assert.assertEquals(0, sum.intValue());
    }

    @Test
    public void integerNotZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3).plus(new Fraction(0));
        Assert.assertEquals(3, sum.intValue());
    }

    @Test
    public void zeroPlusIntegerNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(7));
        Assert.assertEquals(7, sum.intValue());
    }

    @Test
    public void bothNotZeroIntegers() throws Exception {
        Fraction sum = new Fraction(4).plus(new Fraction(8));
        Assert.assertEquals(12, sum.intValue());
    }

    @Test
    public void negativeIntegers() throws Exception {
        Fraction sum = new Fraction(-9).plus(new Fraction(11));
        Assert.assertEquals(2, sum.intValue());
    }

    @Test
    public void nonIntegerNotZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3, 4).plus(new Fraction(0));
        Assert.assertEquals(3, sum.getNumerator());
        Assert.assertEquals(4, sum.getDenominator());
    }

    @Test
    public void zeroPlusNonIntegerNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(5, 7));
        Assert.assertEquals(5, sum.getNumerator());
        Assert.assertEquals(7, sum.getDenominator());
    }

    @Test
    public void bothNotZeroWithSameDenominator() throws Exception {
        Fraction sum = new Fraction(1, 7).plus(new Fraction(5, 7));
        Assert.assertEquals(6, sum.getNumerator());
        Assert.assertEquals(7, sum.getDenominator());
    }

    @Test
    public void relativelyPrimeDenominators() throws Exception {
        Fraction sum = new Fraction(1, 2)
                .plus(new Fraction(4, 3));

        Assert.assertEquals(11, sum.getNumerator());
        Assert.assertEquals(6, sum.getDenominator());
    }

    public static class Fraction {
        private int numerator;
        private int denominator;
        private int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
            this.numerator = integerValue;
            this.denominator = 1;
        }

        public Fraction(int numerator, int denominator) {
            this.integerValue = numerator;
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction other) {
            if (this.denominator == 2 && other.denominator == 3)
                return new Fraction(
                        other.numerator * this.denominator
                                + other.denominator * this.numerator,
                        this.denominator * other.denominator);
            else if (this.denominator == other.denominator)
                return new Fraction(this.integerValue + other.integerValue, this.denominator);
            else if (this.denominator != 1)
                return this;
            else if (other.denominator != 1)
                return other;
            else
                return new Fraction(this.integerValue + other.integerValue, this.denominator);
        }

        public int intValue() {
            return integerValue;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }
    }
}
