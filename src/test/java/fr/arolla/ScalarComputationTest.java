package fr.arolla;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScalarComputationTest {

    @Test
    void should_compute_scalar() {
        float[] a = {1.0f, 2.0f};
        float[] b = {2.0f, 3.0f};
        float[] c = new float[2];
        var scalarComputation = new ScalarComputation();

        scalarComputation.compute(a, b, c);

        assertThat(c).isNotEmpty();
        assertThat(c[0]).isEqualTo(-5.0f);
        assertThat(c[1]).isEqualTo(-13.0f);
    }
}
