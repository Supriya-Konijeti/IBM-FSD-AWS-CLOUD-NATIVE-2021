package comm.exercise2;
import java.io.*;
import java.util.*;

public class Storefile {

    public static void main(String a[]){
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("foo.txt"));
            while (strLine != null)
            {
                strLine = br.readLine();
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
                if (strLine==null)
                    break;
                list.add(strLine);
            }
            System.out.println(Arrays.toString(list.toArray()));
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
}
