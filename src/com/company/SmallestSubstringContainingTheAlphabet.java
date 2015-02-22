package com.company;

import java.util.ArrayList;

/**
 * Created by aleksandar.peychev on 22.2.2015 г..
 */
public class SmallestSubstringContainingTheAlphabet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> a = new ArrayList<String>();
        a = smallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn");
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).length() < a.get(i + 1).length()) {
                a.set(i + 1, a.get(i));
            }
        }
        System.out.println(a.get(a.size() - 1));
    }

    public static ArrayList<String> smallestSubstringContainingTheAlphabet(String str) {

        ArrayList<String> alph22 = new ArrayList<String>();

        for (int i = 1; i < str.length(); i++) {
            ArrayList<Character> alph = new ArrayList<Character>();
            ArrayList<Character> alph2 = new ArrayList<Character>();
            alph.add('a');
            alph.add('b');
            alph.add('c');
            alph.add('d');
            alph.add('e');
            alph.add('f');
            alph.add('g');
            alph.add('h');
            alph.add('i');
            alph.add('j');
            alph.add('k');
            alph.add('l');
            alph.add('m');
            alph.add('n');
            alph.add('o');
            alph.add('p');
            alph.add('q');
            alph.add('r');
            alph.add('s');
            alph.add('t');
            alph.add('u');
            alph.add('v');
            alph.add('w');
            alph.add('x');
            alph.add('y');
            alph.add('z');
            int size = alph.size();
            int j = i - 1;
            do {

                if (size != 0) {
                    alph2.add(str.charAt(j));
                } else {
                    break;
                }
                for (int x = 0; x < alph.size(); x++) {
                    if (alph.get(x) == str.charAt(j)) {
                        alph.remove(x);
                        --size;
                    }
                }

                j++;
            }
            while (j < str.length());
            if (size == 0) {
                alph22.add(String.valueOf(alph2));
            }
        }
        return alph22;

    }
}
