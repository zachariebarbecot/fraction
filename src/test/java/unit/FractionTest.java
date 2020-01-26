package unit;

import com.zbar.kata.fraction.Fraction;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FractionTest {

    @Test
    public void shouldNotHaveFractionWithDenominatorAtZero() {
        assertThatThrownBy(() -> new Fraction(1, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Can not make fraction with denominator at zero");
    }

    @Test
    public void shouldSimplifyFraction() {
        assertThat(new Fraction(2, 4))
                .isEqualTo(new Fraction(1, 2));
    }

    @Nested
    class Add {

        @Test
        public void shouldCalculateWithNumeratorAtZero() {
            var f = new Fraction(0, 1);
            assertThat(f.add(f)).isEqualTo(new Fraction(0, 1));
        }

        @Test
        public void shouldCalculateWithSameDenominator() {
            var f = new Fraction(1, 2);
            assertThat(f.add(f)).isEqualTo(new Fraction(2, 2));
        }

        @Test
        public void shouldCalculateWithDifferentDenominator() {
            var f1 = new Fraction(1, 2);
            var f2 = new Fraction(1, 3);
            assertThat(f1.add(f2)).isEqualTo(new Fraction(5, 6));
        }
    }

    @Nested
    class Subtract {

        @Test
        public void shouldCalculateWithNumeratorAtZero() {
            var f = new Fraction(0, 1);
            assertThat(f.subtract(f)).isEqualTo(new Fraction(0, 1));
        }

        @Test
        public void shouldCalculateWithSameDenominator() {
            var f = new Fraction(1, 2);
            assertThat(f.subtract(f)).isEqualTo(new Fraction(0, 2));
        }

        @Test
        public void shouldCalculateWithDifferentDenominator() {
            var f1 = new Fraction(1, 2);
            var f2 = new Fraction(1, 3);
            assertThat(f1.subtract(f2)).isEqualTo(new Fraction(1, 6));
        }
    }

    @Nested
    class Multiply {

        @Test
        public void shouldCalculateWithNumeratorAtZero() {
            var f = new Fraction(0, 1);
            assertThat(f.multiply(f)).isEqualTo(new Fraction(0, 1));
        }

        @Test
        public void shouldCalculateWithSameDenominator() {
            var f = new Fraction(1, 2);
            assertThat(f.multiply(f)).isEqualTo(new Fraction(1, 4));
        }

        @Test
        public void shouldCalculateWithDifferentDenominator() {
            var f1 = new Fraction(1, 2);
            var f2 = new Fraction(1, 3);
            assertThat(f1.multiply(f2)).isEqualTo(new Fraction(1, 6));
        }
    }

    @Nested
    class Divide {

        @Test
        public void shouldNotCalculateWithNumeratorAtZero() {
            var f = new Fraction(0, 1);
            assertThatThrownBy(() -> f.divide(f))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessageContaining("Can not make fraction with denominator at zero");
        }

        @Test
        public void shouldCalculateWithSameDenominator() {
            var f = new Fraction(1, 2);
            assertThat(f.divide(f)).isEqualTo(new Fraction(2, 2));
        }

        @Test
        public void shouldCalculateWithDifferentDenominator() {
            var f1 = new Fraction(1, 2);
            var f2 = new Fraction(1, 3);
            assertThat(f1.divide(f2)).isEqualTo(new Fraction(3, 2));
        }
    }
}
