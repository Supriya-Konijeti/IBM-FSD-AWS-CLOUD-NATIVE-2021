package comm.exercise3;

import java.util.*;

public class Tester3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> countryStateList=new ArrayList<String>();
        //Creating a set to hold the country names
        Set<String> set=new LinkedHashSet<String>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String countryStateCapitalPair=sc.next();
            countryStateList.add(countryStateCapitalPair);
            String[]array=countryStateCapitalPair.split("\\|");
            set.add(new String(array[0]));
        }
        List<Country>countryList=new ArrayList<Country>();
        for(String country:set)
        {
            List<State>stateList=new ArrayList<State>();
            for(String countryState:countryStateList)
            {
                String[]array2=countryState.split("\\|");
                if(country.equalsIgnoreCase(array2[0]))
                {
                    stateList.add(new State(array2[1]));
                }
            }
            Country cntr=new Country(country,stateList);
            countryList.add(cntr);
        }
        System.out.println("Countries and States in ascending order\r\n" + "");
        Collections.sort(countryList);
        for(Country cntry:countryList)
        {
            System.out.println(cntry.getName());
            Collections.sort(cntry.getStateList());
            for(State st:cntry.getStateList())
            {
                System.out.println("--"+st.getName());
            }
        }
    }
}
