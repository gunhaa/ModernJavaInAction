package mynote.c4567Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDish {

    public static List<Dish> getMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }

    public static List<String> getHelloWorld(){
        return Arrays.asList("Hello", "World");
    }

    // 스트림은 객체 생성과 함수 호출 등의 오버헤드로 인해 for문보다 비용이 클 수 있다
    // 병렬 스트림은 큰 데이터셋에서 병렬 연산 시 성능 향상이 가능하나, 모든 경우에 빠르진 않다
    // 병렬 스트림의 스레드 포크와 조인은 많은 메모리소모를 유발하며, 속도와 트레이드 오프한다

    // 스트림은 선언형 스타일로 가독성을 높일 수 있으나, 모든 경우에 효율적인 것은 아니다
    // 성능이 중요한 로직이나 반복 횟수가 많은 코드에서는 전통적 for문이 낫다
    // 간결성과 성능 사이의 균형을 잡는 것이 중요하다
    public static void main(String[] args) {
        List<Dish> menu = getMenu();

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);


        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegetarianMenu);

        List<Dish.Type> dishType = menu.stream()
                .map(Dish::getType)
                .collect(Collectors.toList());
        System.out.println(dishType);

        List<String> helloWorld = getHelloWorld();
        List<String[]> helloWorldStream = helloWorld.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(helloWorldStream.get(0)));
        System.out.println(Arrays.toString(helloWorldStream.get(1)));

        List<String> uniqueHelloWorldStream = helloWorld.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueHelloWorldStream);
    }
}
