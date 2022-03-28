package fr.arolla;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectManagerTest {

    @Test
    void should_return_string_length_for_string_input() {
        int result = ObjectManager.evaluate("Toto");

        assertThat(result).isEqualTo(4);
    }

    @Test
    void should_return_integer_value_for_integer_input() {
        int result = ObjectManager.evaluate(67);

        assertThat(result).isEqualTo(67);
    }

    @Test
    void should_return_zero_for_other_input() {
        int result = ObjectManager.evaluate(BigDecimal.ONE);

        assertThat(result).isZero();
    }

    @Test
    void should_return_zero_for_null_input() {
        int result = ObjectManager.evaluate(null);

        assertThat(result).isZero();
    }
}
