package mynote.c2BehaviorParameterization;

import java.util.ArrayList;
import java.util.List;

public interface Predicate<T> {
    boolean test(T t);

    // 람다를 위한 함수를 미리 구현
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}
