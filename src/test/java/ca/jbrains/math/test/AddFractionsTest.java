package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void zeroPlusZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assert.assertEquals(0, sum.getNumerator());
        Assert.assertEquals(1, sum.getDenominator());
        Assert.assertEquals(new Fraction(0), sum);
    }

    @Test
    public void integerNotZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3).plus(new Fraction(0));
        Assert.assertEquals(3, sum.getNumerator());
        Assert.assertEquals(1, sum.getDenominator());
        Assert.assertEquals(new Fraction(3), sum);
    }

    @Test
    public void zeroPlusIntegerNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(7));
        Assert.assertEquals(7, sum.getNumerator());
        Assert.assertEquals(1, sum.getDenominator());
        Assert.assertEquals(new Fraction(7), sum);
    }

    @Test
    public void bothNotZeroIntegers() throws Exception {
        Fraction sum = new Fraction(4).plus(new Fraction(8));
        Assert.assertEquals(12, sum.getNumerator());
        Assert.assertEquals(1, sum.getDenominator());
        Assert.assertEquals(new Fraction(12), sum);
    }

    @Test
    public void negativeIntegers() throws Exception {
        Fraction sum = new Fraction(-9).plus(new Fraction(11));
        Assert.assertEquals(2, sum.getNumerator());
        Assert.assertEquals(1, sum.getDenominator());
        Assert.assertEquals(new Fraction(2), sum);
    }

    @Test
    public void nonIntegerNotZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3, 4).plus(new Fraction(0));
        Assert.assertEquals(3, sum.getNumerator());
        Assert.assertEquals(4, sum.getDenominator());
        Assert.assertEquals(new Fraction(3, 4), sum);
    }

    @Test
    public void zeroPlusNonIntegerNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(5, 7));
        Assert.assertEquals(5, sum.getNumerator());
        Assert.assertEquals(7, sum.getDenominator());
        Assert.assertEquals(new Fraction(5, 7), sum);
    }

    @Test
    public void bothNotZeroWithSameDenominator() throws Exception {
        Fraction sum = new Fraction(1, 7).plus(new Fraction(5, 7));
        Assert.assertEquals(6, sum.getNumerator());
        Assert.assertEquals(7, sum.getDenominator());
        Assert.assertEquals(new Fraction(6, 7), sum);
    }

    @Test
    public void relativelyPrimeDenominators() throws Exception {
        Fraction sum = new Fraction(1, 2)
                .plus(new Fraction(4, 3));

        Assert.assertEquals(11, sum.getNumerator());
        Assert.assertEquals(6, sum.getDenominator());
        Assert.assertEquals(new Fraction(11, 6), sum);
    }

    @Ignore("Work in progress")
    @Test
    public void denominatorsWithCommonFactors() throws Exception {
        Fraction sum = new Fraction(1, 4)
                .plus(new Fraction(1, 2));

        Assert.assertEquals(3, sum.getNumerator());
        Assert.assertEquals(4, sum.getDenominator());
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

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
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
    }
}
