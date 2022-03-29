package fr.arolla;

public class ScalarComputation {

    // FIXME Try to use the new Vector API here by following the documentation (see README file)
    void compute(float[] a, float[] b, float[] c) {
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }
}
