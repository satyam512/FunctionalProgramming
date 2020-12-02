import Playground.interfaces.FirstInterface;
import Playground.interfaces.FunctionalGeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        FirstInterface obj1 = () -> System.out.println("I'm here");
        firstGo(obj1);

        // generics

        FunctionalGeneric<String, Integer> stringLength = String::length;

        FunctionalGeneric<String, String> concatAppleToString = s-> "Apples and " + s;
        System.out.println(stringLength.execute("Batman"));
        System.out.println(concatAppleToString.execute("Oranges"));

        // Predefined Functional interfaces

        // Predicate : return true/false, takes one argument (can use BiPredicate for two args)

        Predicate<Integer> ifEven = i -> i%2 == 0;
        System.out.println(ifEven.test(298));

        List<Integer> numbers = Arrays.asList(56, 45, 49, 23, 83, 86, 21);
        List<Integer> evenNumbers = getFilteredResult(numbers, ifEven);

        System.out.println(evenNumbers);

        System.out.println("Well ....");

        List<String> someWords = new ArrayList<>();
        someWords.add("Battery");
        someWords.add("Captain");
        someWords.add("Angry");
        someWords.add("Vengeance");
        someWords.add("Knight");

        Predicate<String> evenLength = s -> s.length()%2==0;
        Predicate<String> oddLength = s -> s.length()%2!=0;
        List<String> filteredWords = getFilteredResult(someWords, oddLength);
        System.out.println(filteredWords);

        // Consumer : consumer takes and argument and returns nothing

        Consumer<Integer> consumer = e -> System.out.println(e);
        for(Integer i : numbers)
            consumer.accept(i);

        //Supplier : supplier takes no arguments and returns something
        //Use case would be like returning random numbers

        Supplier<Double> randomGenerator = Math :: random;
        for (int i =0 ;i<5; i++)
            System.out.println(randomGenerator.get());

        // Function : Important as it basically means transformation i.e. it takes something in arg and does some processing and then returns results
        Function<String, String> toUpperCase = s -> s.toUpperCase();
        Function<String, Integer> countVowels = s -> {
            s = s.toLowerCase();
            int ans = 0;
            for(int i=0;i<s.length();i++)
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u')
                    ans++;
            return ans;
        };
        List<String> transfomedList = transformedList(someWords, toUpperCase);
        List<Integer> vowelCount = transformedList(someWords, countVowels);

        System.out.println(transfomedList);
        System.out.println(vowelCount);

    }

    private static <T,R> List<R> transformedList(List<T> original, Function<T, R> transformation) {
        List<R> transformed = new ArrayList<>();
        for(T element : original)
            transformed.add(transformation.apply(element));
        return transformed;
    }


    private static<T> List<T> getFilteredResult(List<T> unfilteredList, Predicate<T> filter) {
        List<T> filteredResult = new ArrayList<>();

        for(T element : unfilteredList) {
            if(filter.test(element))
                filteredResult.add(element);
        }
        return filteredResult;
    }

    private static void firstGo(FirstInterface obj1) {
        obj1.execute();
    }
}
