package mynote.c4567Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTrader {

    public static List<Transaction> getDataSet(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
        List<Transaction> transactions = getDataSet();

        // 2011년에 일어난 모든 트랜잭션을 찾아 오름차순 정리
        List<Transaction> sorted1 = transactions.stream()
                .filter(tx -> tx.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(sorted1);

        // 거래자가 근무하는 모든 도시를 중복 없이 나열
        List<String> sorted2 = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(sorted2);

        // 케임브리지에 근무하는 모든 거래자를 찾아 이름순으로 정렬
        List<Trader> sorted3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(trader -> trader.getName()))
                .collect(Collectors.toList());
        System.out.println(sorted3);
        
        // 모든 거래자의 이름을 알파벳 순으로 정렬후 하나의 문자열로 반환
        String sorted4 = transactions.stream()
                .map(tx -> tx.getTrader().getName())
                .distinct()
                .sorted()
                            // StringBuilder로 내부 구현
                .collect(Collectors.joining());

        System.out.println(sorted4);

        // 밀라노에 거래자가 있는지?
        boolean sorted5 = transactions.stream()
                .anyMatch(tx -> tx.getTrader().getCity().equals("Milan"));
        System.out.println(sorted5);

        
        // 케임브릿지에 거주하는 거래자의 모든 트랜잭션 값 출력
        transactions.stream()
                .filter(tx -> tx.getTrader().getCity().equals("Cambridge"))
                .map(tx -> tx.getValue())
                .forEach(System.out::println);

        // 전체 트랜잭션 중 최댓값
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));
        System.out.println(max.get());

        // 전체 트랜잭션 중 최솟값
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.get());
    }

}
