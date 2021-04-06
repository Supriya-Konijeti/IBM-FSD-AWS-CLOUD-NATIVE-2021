package comm.exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class Tester4  extends LetterSequence{
    public Tester4(String sentence) {
        super(sentence);
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the input string");
        String line = br.readLine();
        LetterSequence ls = new LetterSequence(line);
        TreeMap<String, Integer> frequencyMap = ls.computeFrequency();
        ls.displayFrequency(frequencyMap);
    }
}
