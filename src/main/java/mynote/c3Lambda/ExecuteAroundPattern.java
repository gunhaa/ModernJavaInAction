package mynote.c3Lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {

    private static final String PATH = "src/main/java/mynote/static/data.txt";

    public String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(PATH))){
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        ExecuteAroundPattern executeAroundPattern = new ExecuteAroundPattern();
        String s = executeAroundPattern.processFile();
        System.out.println(s);
    }
}
