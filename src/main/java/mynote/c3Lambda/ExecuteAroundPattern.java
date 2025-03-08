package mynote.c3Lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {

    private static final String PATH = "src/main/java/mynote/static/data.txt";

    public String processFileV1() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(PATH))){
            return br.readLine();
        }
    }

    public String processFileV2(BufferedReaderProcessor brp) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(PATH))){
            return brp.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        ExecuteAroundPattern executeAroundPattern = new ExecuteAroundPattern();
        // 한줄 출력
        String s = executeAroundPattern.processFileV1();
        System.out.println(s);
        System.out.println("============================");
        // 두줄 출력
        String s2 = executeAroundPattern.processFileV2((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(s2);
    }
}
