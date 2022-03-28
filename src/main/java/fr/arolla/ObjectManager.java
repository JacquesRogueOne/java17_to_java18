package fr.arolla;

public class ObjectManager {

    // FIXME It must be possible to use a switch here
    public static int evaluate(Object object) {
        if (object instanceof String) {
            return ((String) object).length();
        }

        if (object instanceof Integer) {
            return (Integer) object;
        }

        return 0;
    }
}
