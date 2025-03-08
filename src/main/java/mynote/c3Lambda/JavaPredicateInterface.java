package mynote.c3Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JavaPredicateInterface {

    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T t : list){
            if(p.test(t)){
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {

        List<String> listOfStrings = new ArrayList<>();

        listOfStrings.add("1");
        listOfStrings.add("2");
        listOfStrings.add("");
        listOfStrings.add("3");
        listOfStrings.add("4");
        System.out.println(listOfStrings);

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> filterList = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(filterList);
    }


}
