package comm.exercise3;

import java.util.List;

public class Country {
    private String name;
    private List<State> stateList;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<State> getStateList() {
        return stateList;
    }
    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
    public Country(String name, List<State> stateList2) {
        super();
        this.name = name;
        this.stateList = stateList2;
    }
    public int compareTo(Country c)
    {
        return name.compareTo(c.getName());
    }
}
