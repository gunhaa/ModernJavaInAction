package mynote.c2BehaviorParameterization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BehaviorParameterizationExecutor {
    public static void main(String[] args) {

//        int param1= 160;
        Color param2= Color.RED;
        Color param3= Color.GREEN;

        Apple apple1 = new Apple("apple1", 160, param2);
        Apple apple2 = new Apple("apple2", 159, param2);
        Apple apple3 = new Apple("apple3", 158, param3);
        ApplePredicate p = new AppleRedAndHeavyPredicate();

        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);

        List<Apple> selectedApples = filterApples(inventory, p);

        // 익명 클래스 사용
        List<Apple> greenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.GREEN.equals(apple.getColor());
            }
        });

        // 단 하나의 추상메소드를 가진 인터페이스이기에 가능하다
        List<?> greenApplesLambda = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        System.out.println("size는 2");
        System.out.println("selectedApples.size() = " + selectedApples.size());

        System.out.println("size는 1");
        System.out.println("greenApples.size() = " + greenApples.size());

        System.out.println("size는 2");
        System.out.println("greenApplesLambda.size() = " + greenApplesLambda.size());

        List<Apple> filterGreenApple = Predicate.filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println("size는 2");
        System.out.println("filterGreenApple.size() = " + filterGreenApple.size());

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println("inventory.get(0) = " + inventory.get(0));

        inventory.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));
        System.out.println("lambdaInventory.get(0) = " + inventory.get(0));
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
