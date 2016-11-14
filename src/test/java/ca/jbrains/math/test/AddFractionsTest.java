package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void zeroPlusZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assert.assertEquals(new Fraction(0), sum);
    }

    @Test
    public void integerNotZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3).plus(new Fraction(0));
        Assert.assertEquals(new Fraction(3), sum);
    }

    @Test
    public void zeroPlusIntegerNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(7));
        Assert.assertEquals(new Fraction(7), sum);
    }

    @Test
    public void bothNotZeroIntegers() throws Exception {
        Fraction sum = new Fraction(4).plus(new Fraction(8));
        Assert.assertEquals(new Fraction(12), sum);
    }

    @Test
    public void negativeIntegers() throws Exception {
        Fraction sum = new Fraction(-9).plus(new Fraction(11));
        Assert.assertEquals(new Fraction(2), sum);
    }

    @Test
    public void nonIntegerNotZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3, 4).plus(new Fraction(0));
        Assert.assertEquals(new Fraction(3, 4), sum);
    }

    @Test
    public void zeroPlusNonIntegerNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(5, 7));
        Assert.assertEquals(new Fraction(5, 7), sum);
    }

    @Test
    public void bothNotZeroWithSameDenominator() throws Exception {
        Fraction sum = new Fraction(1, 7).plus(new Fraction(5, 7));
        Assert.assertEquals(new Fraction(6, 7), sum);
    }

    @Test
    public void relativelyPrimeDenominators() throws Exception {
        Fraction sum = new Fraction(1, 2)
                .plus(new Fraction(4, 3));

        Assert.assertEquals(new Fraction(11, 6), sum);
    }

    @Test
    public void denominatorsWithCommonFactors() throws Exception {
        Fraction sum = new Fraction(1, 4)
                .plus(new Fraction(1, 2));
        Assert.assertEquals(new Fraction(3, 4), sum);
    }

    @Test
    public void sumIsAnInteger() throws Exception {
        Assert.assertEquals(
                new Fraction(2),
                new Fraction(1, 2).plus(new Fraction(3, 2))
        );
    }

    @Test
    public void nonIntegerPlusInteger() throws Exception {
        Assert.assertEquals(
                new Fraction(3, 2),
                new Fraction(1, 2).plus(new Fraction(1))
        );
    }

    @Test
    public void negativePlusPositive() throws Exception {
        Assert.assertEquals(
                new Fraction(1, 4),
                new Fraction(-7, 4).plus(new Fraction(2))
        );
    }

    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int integerValue) {
            this(integerValue, 1);
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction other) {
            if (this.denominator == other.denominator)
                return new Fraction(
                        this.numerator + other.numerator,
                        this.denominator);
            else
                return new Fraction(
                        other.numerator * this.denominator
                                + other.denominator * this.numerator,
                        this.denominator * other.denominator);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Fraction) {
                Fraction that = (Fraction) other;
                return (this.numerator * that.denominator
                        == that.numerator * this.denominator);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%d/%d", numerator, denominator);
        }
    }
}
