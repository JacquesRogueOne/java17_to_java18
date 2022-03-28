# From Java 17 to Java 18
This kata will help you to discover and experiment new features appeared in Java 18.

In this pandemic times, the subject is about hospital.

You will have to follow the FIXME present into the code which show you where you can use Java 18 new features.

## What do I need for this kata ?
* Git to checkout this code
* Maven for dependencies
* Java 18 of course (look here for new release [OpenJDK](https://adoptopenjdk.net/))
* An up to date IDE for easier life (the 2022 EAP release of [IntelliJ](https://www.jetbrains.com/idea/nextversion) works perfectly for example)

Some new features in Java 18 you will have to play with :

(All showed examples are mostly from OpenJDK website)

## Improved switch
It's now stable and fully usable in your programs :)

Example:
```java
//Before
switch (day) {
    case MONDAY:
    case FRIDAY:
    case SUNDAY:
        System.out.println(6);
        break;
    case TUESDAY:
        System.out.println(7);
        break;
    case THURSDAY:
    case SATURDAY:
        System.out.println(8);
        break;
    case WEDNESDAY:
        System.out.println(9);
        break;
}

// From Java 14
switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
    case TUESDAY                -> System.out.println(7);
    case THURSDAY, SATURDAY     -> System.out.println(8);
    case WEDNESDAY              -> System.out.println(9);
}

// Other case with variable assignment
// Before
int numLetters;
switch (day) {
    case MONDAY:
    case FRIDAY:
    case SUNDAY:
        numLetters = 6;
        break;
    case TUESDAY:
        numLetters = 7;
        break;
    case THURSDAY:
    case SATURDAY:
        numLetters = 8;
        break;
    case WEDNESDAY:
        numLetters = 9;
        break;
    default:
        throw new IllegalStateException("Wat: " + day);
}

// From Java 14
int numLetters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case THURSDAY, SATURDAY     -> 8;
    case WEDNESDAY              -> 9;
};

// And if you have a block of code
int j = switch (day) {
    case MONDAY  -> 0;
    case TUESDAY -> 1;
    default      -> {
        int k = day.toString().length();
        int result = f(k);
        yield result;
    }
};

// And also with the new yield reserved word if you don't want to use the ->
int result = switch (s) {
    case "Foo": 
        yield 1;
    case "Bar":
        yield 2;
    default:
        System.out.println("Neither Foo nor Bar, hmmm...");
        yield 0;
};
```

As you understand, you will have to enable preview features in your IDE and the POM file to play with all the visible new things brought by Java 18.

Enjoy !
