package se.lexicon;

import java.util.Random;
import java.util.function.*;

public class UtilFunctionsDemo {
    // Function<T, R>
    void main() {
        Function<String, Integer> stringToLength = s -> s.length();
        Function<Todo, String> todoToString = todo -> todo.getTitle();
        Function<Double, Double> fahrenheitToCelsius = f -> (f - 32) * 5 / 9;


        IO.println("Length of 'Java':" + stringToLength.apply("Java"));
        IO.println("Fahrenheit to Celsius: " + fahrenheitToCelsius.apply(100.0));
        IO.println("Get Title from Todo:" + todoToString.apply(new Todo("Test", 2, false)));


        Predicate<Integer> isEven = number -> number % 2 == 0;
        IO.println("Is 10 even? " + isEven.test(10));

        Consumer<String> printUpperCase = s -> IO.println(s.toUpperCase());
        Consumer<String> printLowerCase = s -> IO.println(s.toLowerCase());
        printUpperCase.accept("Hello");
        printLowerCase.accept("Hello");

        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
        IO.println("Random number: " + randomNumber.get());

        UnaryOperator<Integer> square = number -> number * number;
        IO.println("Square of 5: " + square.apply(5));

        UnaryOperator<String> reverse = s -> new StringBuilder(s).reverse().toString();
        IO.println("Reverse of 'Hello': " + reverse.apply("Hello"));
    }
}
