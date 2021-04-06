package comm.example3;

import java.io.*;

public class SerializeAnimation {
    public static void main(String[] args) {

        // Create an object instance
        PersistantTime4 a = new PersistantTime4(1);

        // Serialize the object
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("serializedfile");
            out = new ObjectOutputStream(fos);
            out.writeObject(a);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        // Deserialize the object.  The problem is that the
        // PersistentAnimation thread does not get started
        // automatically after the deserialization since its
        // constructor method does not get called when the
        // serialized object is deserialized.  This is why
        // the PersistentAnimation class has to have its own
        // readObject() method in which the thread is
        // explicitly started.

        PersistantTime4 b = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("serializedfile");
            in = new ObjectInputStream(fis);
            b = (PersistantTime4) in.readObject();
            in.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
