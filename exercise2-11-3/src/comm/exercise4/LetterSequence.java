package comm.exercise4;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LetterSequence {
    private String sentence;

    public LetterSequence(String sentence)
    {
        this.sentence=sentence;
    }

    public TreeMap<String,Integer>computeFrequency()
    {
        Set<String> set=new TreeSet<String>();
        TreeMap<String,Integer>frequencyMap=new TreeMap<String,Integer>();
        int count=0;
        for(int i=0;i<sentence.length();i++)
        {
            set.add(sentence.charAt(i)+"");
        }
        for(String str:set)
        {
            for(int j=0;j<sentence.length();j++)
            {
                if((sentence.charAt(j)+"").equals(str))
                    count++;
            }
            frequencyMap.put(str, count);
            count=0;
        }
        return frequencyMap;

    }

    public void displayFrequency(TreeMap<String,Integer> frequencyMap)
    {
        for(String str:frequencyMap.keySet())
        {
            int count=frequencyMap.get(str);
            System.out.print(str);
            for(int i=0;i<count;i++)
                System.out.println("*");
        }
    }
   }
