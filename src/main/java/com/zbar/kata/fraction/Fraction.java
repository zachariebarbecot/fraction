package com.zbar.kata.fraction;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
public class Fraction {

    private final long numerator;
    private final long denominator;

    public Fraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Can not make fraction with denominator at zero");
        }
        var gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).longValue();
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction add(Fraction f2) {
        return new Fraction(
                this.numerator * f2.denominator + f2.numerator * this.denominator,
                this.denominator * f2.denominator
        );
    }

    public Fraction subtract(Fraction f2) {
        return add(
                new Fraction(-f2.numerator, f2.denominator)
        );
    }

    public Fraction multiply(Fraction f2) {
        return new Fraction(
                this.numerator * f2.numerator,
                this.denominator * f2.denominator
        );
    }

    public Fraction divide(Fraction f2) {
        return multiply(
                new Fraction(f2.denominator, f2.numerator)
        );
    }
}
