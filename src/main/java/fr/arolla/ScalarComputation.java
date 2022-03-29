package fr.arolla;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class ScalarComputation {
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;
    // FIXME Try to use the new Vector API here by following the documentation (see README file)
    void compute2(float[] a, float[] b, float[] c) {
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }
    void compute(float[] a, float[] b, float[] c) {
        for (int i = 0; i < a.length; i += SPECIES.length()) {
            // VectorMask<Float>  m;
            var m = SPECIES.indexInRange(i, a.length);
            // FloatVector va, vb, vc;
            var va = FloatVector.fromArray(SPECIES, a, i, m);
            var vb = FloatVector.fromArray(SPECIES, b, i, m);
            var vc = va.mul(va)
                    .add(vb.mul(vb))
                    .neg();
            vc.intoArray(c, i, m);
        }
    }
}
