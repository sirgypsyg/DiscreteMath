package org.example;

import java.util.*;
class Ackermann {
    public List<String> values = new ArrayList<>();
    public int counter = 0;
    public int ackermann(int m, int n){
        values.add("A("+ m + "," + n + ") =");
        if (m == 0) {
            values.add(n + 1 + "");
            ++counter;
            return n + 1;
        }
        if (m > 0 && n == 0) {
            values.add("A("+ (m-1) + "," + 1 + ")");
            ++counter;
            return ackermann(m-1, 1);
        }
        else {
            values.add("A("+ (m-1) + "," + "A("+ (m) + "," + (n-1) + ")" + ")");
            ++counter;
            return ackermann(m-1, ackermann(m, n-1));
        }
    }

    public void modify(){
        String[] temp;

        List<String> modified = new ArrayList<>();
        modified.add("(1.2)\t " + values.get(0) + values.get(1) + "(1.3)");

        int count = 1;
        temp = values.get(1).split(",");
        String mod = "=";
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
            int openingBrackets = mod.length() - mod.replace("(", "").length();
            int closingBrackets = mod.length() - mod.replace(")", "").length();
            int bracketsDifference = openingBrackets - closingBrackets;
            if (bracketsDifference > 0) {
                String closingBracketsToAdd = ")".repeat(bracketsDifference);
                mod += closingBracketsToAdd;
            }


            modified.add("(1."+ (j+3) +")" + "\t\t\t=" + mod);
        }
        for (var p : modified)
            System.out.println(p);
    }
}

public class Main {
    public static void main(String[] args) {
        Ackermann ackermann = new Ackermann();
        ackermann.ackermann(2,2);
        //System.out.println(ackermann.values);
        //System.out.println(ackermann.counter);
        ackermann.modify();

    }
}