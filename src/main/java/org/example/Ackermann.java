package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ackermann {
    public List<String> values = new ArrayList<>();
    public int counter = 0;
    public int ackermann(int m, int n){
        values.add("A("+ m + "," + n + ") =");
        if (m == 0) {
            values.add(String.valueOf(n+1 + "\n"));
            ++counter;
            return n + 1;
        }
        if (m > 0 && n == 0) {
            values.add("A("+ (m-1) + "," + 1 + ")\n");
            ++counter;
            return ackermann(m-1, 1);
        }
        else {
            values.add("A("+ (m-1) + "," + "A("+ (m) + "," + (n-1) + ")" + ")\n");
            ++counter;
            return ackermann(m-1, ackermann(m, n-1));
        }
    }


    public void modify(){
        String temp[];
        String arr[] = new String[2];

        List<String> modified = new ArrayList<>();
        modified.add("(1.2)\t " + values.get(0) + values.get(1) + "(1.3)");

        int count = 1;
        temp = values.get(1).split(",");
        String mod = "\t\t=";
        for (int j = 0; j < values.size()/2 - 1; ++j){
            if (j!=0)
                temp = mod.split(",");
            mod = "";
            for (int i = 0; i < temp.length - 1; ++i){
                if (i == temp.length-2)
                    mod += values.get(count+=2);
                else
                    mod += temp[i] + ",";
            }
            if (j+2 <= 10)
                modified.add("\t\t\t=" + mod + "(1."+ (j+4) +")");
            else if (j+2 == counter)
                modified.add("\t\t=" + mod);
            else
                modified.add("\t\t=" + mod + "(1."+ (j+4) +")");

        }
        System.out.println(modified);
    }
}
