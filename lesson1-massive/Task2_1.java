package com.company;

public class Main {

    public static void main(String[] args) {
        int i = 3;
        int a = i++; // a = 3, i = 4
        int b = ++a; // b = 4, a = 4

/* i++ and ++i are very similar but not exactly the same.
Both increment the number, but ++i increments the number before the current expression is evaluted,
 whereas i++ increments the number after the expression is evaluated. */
    }
}
