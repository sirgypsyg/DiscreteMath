package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ackermann ackermann = new Ackermann();
        ackermann.ackermann(2,2);
        //System.out.println(ackermann.values);
        //System.out.println(ackermann.counter);
        ackermann.modify();

    }
}