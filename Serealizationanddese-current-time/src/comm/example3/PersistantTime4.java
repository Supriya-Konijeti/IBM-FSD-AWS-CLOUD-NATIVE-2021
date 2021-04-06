package comm.example3;

import java.io.Serializable;

public class PersistantTime4 implements Serializable,Runnable
{
    transient private Thread animator;
    private int animationSpeed;

    public PersistantTime4(int animationSpeed) {
        this.animationSpeed = animationSpeed;
        animator = new Thread(this);
        animator.start();
    }

    public void run() {
        System.out.println("PersistentAnimation thread is started");
    }
}
