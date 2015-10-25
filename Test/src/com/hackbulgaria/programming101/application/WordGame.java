package com.hackbulgaria.programming101.application;

import java.util.Scanner;

public class WordGame {

    public static int count(char[][] map, String word) {

        if (map.length == 0) {
            return 0;
        }

        int rows = map.length;
        int columns = map[0].length;
        int result = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx == 0 && dy == 0) {
                            continue;
                        }
                        int curRow = row;
                        int curColumn = column;
                        int index = 0;
                        while (index < word.length()) {
                            if (curRow < 0 || curRow >= rows || curColumn < 0 || curColumn >= columns) {
                                break;
                            }
                            if (word.charAt(index) != map[curRow][curColumn]) {
                                break;
                            }
                            index++;
                            curRow += dx;
                            curColumn += dy;
                        }
                        if (index == word.length()) {
                            result++;
                        }
                    }
                }
            }
        }

        if (isPalindrome(word)) {
            result /= 2;
        }

        return result;
    }

    private static boolean isPalindrome(String word) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String searched = scanner.next();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.next().charAt(0);
            }
        }

        System.out.println(count(map, searched));
    }
}
