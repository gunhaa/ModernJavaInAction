package mynote.c3Lambda;

public class LambdaExecutor {
    public static void main(String[] args) {

        
        // runnbale을 구현하면 run에 구현된 함수를 쓰레드로 실행시킨다
        Runnable r1 = () -> System.out.println("r1 execute");

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("r2 execute");
            }
        };

        process(r1);
        process(r2);
        process(()-> System.out.println("lambda execute"));
    }

    public static void process(Runnable r){
        r.run();
    }
}
