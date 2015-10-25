package com.hackbulgaria.programming101.application;

public class Points {

    public static Point movePoint(Point startPoint, String movemenDirections) {

        for (int i = 0; i < movemenDirections.length(); i++) {
            if (movemenDirections.charAt(i) == '<') {
                startPoint.x--;
            } else if (movemenDirections.charAt(i) == '>') {
                startPoint.x++;
            } else if (movemenDirections.charAt(i) == 'v') {
                startPoint.y--;
            } else if (movemenDirections.charAt(i) == '^') {
                startPoint.y++;
            } else {
                while (i != movemenDirections.length() - 1) {
                    char nextDirection = movemenDirections.charAt(++i);
                    switch (nextDirection) {
                    case '<':
                        startPoint.x++;
                        break;
                    case '>':
                        startPoint.x--;
                        break;
                    case 'V':
                        startPoint.y++;
                        break;
                    case '^':
                        startPoint.y--;
                        break;
                    default:
                        break;
                    }
                }
            }
        }

        return startPoint;
    }

    public static void main(String[] args) {
        Point anyPoint = new Point(0, 0);
        
        System.out.println(movePoint(anyPoint, ">v<>>>v^~><><~><><"));
    }
}
