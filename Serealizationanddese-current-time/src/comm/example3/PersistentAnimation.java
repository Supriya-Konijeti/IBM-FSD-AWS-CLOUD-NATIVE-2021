package comm.example3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistentAnimation implements Serializable,Runnable
{
    transient private Thread animator;
    private int animationSpeed;

    public PersistentAnimation(int animationSpeed) {
        this.animationSpeed = animationSpeed;
        startAnimation();
    }

    public void run() {
        System.out.println("PersistentAnimation thread is started");
    }

    // Provide your own writeObject method
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    // Provide your own readObject method
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // our "pseudo-constructor"
        in.defaultReadObject();
        // now we are a "live" object again, so let's run rebuild and start
        startAnimation();

    }

    private void startAnimation() {
        animator = new Thread(this);
        animator.start();
    }
}
