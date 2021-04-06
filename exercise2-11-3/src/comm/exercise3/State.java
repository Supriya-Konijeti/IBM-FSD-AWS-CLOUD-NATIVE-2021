package comm.exercise3;

public class State implements Comparable<State> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State(String name) {
        super();
        this.name = name;
    }
    public int compareTo(State s)
    {
        return name.compareTo(s.getName());
    }
}
