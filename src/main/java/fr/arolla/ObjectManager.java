package fr.arolla;

public class ObjectManager {

    public static int evaluate(Object object) {
        return switch (object) {
            case String s -> s.length();
            case Integer i -> i;
            case null, default -> 0;
        };
    }
}
