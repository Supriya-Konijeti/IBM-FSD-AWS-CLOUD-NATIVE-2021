package comm.example;

import java.io.*;

public class BufferReaderWriterTester {

    public static void main(String args[]) throws IOException {
        try {
            FileReader input = new FileReader("foo1.txt");
            BufferedReader bufInput = new BufferedReader(input);
            try {
                FileWriter output = new FileWriter("out2.txt");
                BufferedWriter bufOutput = new BufferedWriter(output);
                try {
                    String line;
                    // read the first line
                    line = bufInput.readLine();
                    while (line != null) {
                        // write the line out to the output file
                        bufOutput.write(line, 0, line.length());
                        bufOutput.newLine();
                        // read the next line
                        line = bufInput.readLine();
                    }
                } finally {
                    bufOutput.close();
                }
            } finally {
                bufInput.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
