package fr.arolla;

public class ObjectManager {

    public static int evaluate(Object object) {
        return switch (object) {
            case String string -> string.length();
            case Integer integer -> integer;
            case null -> 0;
            default -> 0;
        };
    }
}
