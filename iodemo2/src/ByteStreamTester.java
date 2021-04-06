import java.io.*;

public class ByteStreamTester {
    public static void main(String args[])throws FileNotFoundException
    {
        //Creating a File object
        File file = new File("foo.txt");
        //Creating a FileInputStream object
        FileInputStream inputStream = new FileInputStream(file);
        //Creating a byte array
        byte bytes[] = new byte[(int) file.length()];
        System.out.println("Length of file:"+bytes.length);
        //Reading data into the byte array
        try {
            int numOfBytes = inputStream.read(bytes);
            System.out.println("Length of file: "+numOfBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data copied successfully...");
        //Creating a FileInputStream object
        FileOutputStream outputStream = new FileOutputStream("out.txt");
        //Writing the contents of the Output Stream to a file
        try {
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data written successfully...");
    }
}
