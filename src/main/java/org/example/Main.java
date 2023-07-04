package org.example;

import java.util.*;
class Ackermann {
    public List<String> values = new ArrayList<>();
    public int counter = 0;
    public int ackermann(int m, int n){
        ++counter;
        values.add("A("+ m + "," + n + ") =");
        if (m == 0) {
            values.add(n + 1 + "");
            return n + 1;
        }
        if (m > 0 && n == 0) {
            values.add("A("+ (m-1) + "," + 1 + ")");
            return ackermann(m-1, 1);
        }
        else {
            values.add(String.format("A(%d, A(%d, %d))", m - 1, m, n - 1));
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

    public void ex3(){
        for (int i = 0; i < values.size(); i+=2){
            if (i == values.size() - 2)
                System.out.print(values.get(i).substring(0,6) + ".");
            else
                System.out.print(values.get(i).substring(0,6) + ",");
        }
    }

    public void ex4(){
        int rows = 50; // liczba wierszy
        int columns = 50; // liczba kolumn

        ArrayList<ArrayList<String>> tab = new ArrayList<>(rows);

        for (int i = 0; i < rows; i++) {
            ArrayList<String> row = new ArrayList<>(columns);
            for (int j = 0; j < columns; j++) {
                row.add("0"); // inicjalizacja pustymi łańcuchami
            }
            tab.add(row);
        }

    }
}

class Sudan {
    List<String> values = new ArrayList<>();
    public int S(int n, int x, int y) {
        values.add(String.format("S{%d}(%d, %d) = ", n, x, y));
        if (n == 0){
            values.add(x + y  + "\n");
            return x + y;
        }
        else if (y == 0){
            values.add(x + "\n");
            return x;
        }
        values.add(String.format("S{%d}(S{%d}(%d,%d),S{%d}(%d,%d) ,%d)\n", n-1,n,x,y-1,n,x,y-1,y));
        return S(n - 1, S(n, x, y - 1), S(n, x, y - 1) + y);
    }
}

public class Main {
    public static void main(String[] args) {
//        Ackermann ackermann = new Ackermann();
//        ackermann.ackermann(2,2);
        //System.out.println(ackermann.values);
        //System.out.println(ackermann.counter);
        //ackermann.modify();
        //ackermann.ex3();


        Sudan sudan = new Sudan();
        sudan.S(1,3,3);
        System.out.println(sudan.S(1,3,3));
//        for (var p : sudan.values){
//            System.out.print(p);
//        }



    }
}