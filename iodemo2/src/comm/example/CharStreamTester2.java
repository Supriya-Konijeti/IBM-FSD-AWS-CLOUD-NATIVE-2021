package comm.example;

import java.io.*;

public class CharStreamTester2 {
    public static void main(String args[]) throws IOException {
        File inputFile=new File("foo.txt");

        File outputFile=new File("out.txt");
        File file=new File("C:\\Users\\SupriyaKonijeti\\IdeaProjects\\iodemo2\\src\\comm\\example");
        String str[]=file.list();
        for(String name:str)
        {
            System.out.println(name);
        }

        FileReader reader=new FileReader(inputFile);
        FileWriter writer=new FileWriter(outputFile);
        char[] buffer=new char[128];
        int charRead;
        try {
            charRead=reader.read(buffer);
            while (charRead!=-1)
            {
                System.out.print(charRead+" ");
                writer.write(buffer,0,charRead);
                charRead=reader.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            reader.close();
            writer.close();
        }

    }
}
