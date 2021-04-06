package comm.example;
import java.io.FileNotFoundException;
import java.io.*;
public class exercise1 {
    public static void main(String args[]) throws FileNotFoundException {
        File file=new File("foo.txt");
        FileInputStream inputStream=new FileInputStream(file);
        byte bytes[]= new byte[(int) file.length()];
        System.out.println(bytes.length);

        try {
            int numOfBytes = inputStream.read(bytes);
            System.out.println(numOfBytes);
            for(int i=0;i<bytes.length;i++){
                System.out.println((char) bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 }

