package com.company;

/**
 * Created by aleksandar.peychev on 22.2.2015 г..
 */
public class primesInAnInterval {

    /**
     * @param args
     */
    public static void main(String[] args) {

        primesInAnInterval(10,30);

    }

    /**
     * Finds the prime numbers in an interval
     * @param from - First value of the interval
     * @param to - Last value of the interval
     */
    public static void primesInAnInterval(int from, int to ){

        if (from > to || from < 0 || to < 0 ){
            System.out.println("This input is invalid");
        }
        else{
            for(int i = from; i < to; i++){
                if(isPrimetive(i)){
                    System.out.println(i);
                }
            }
        }

    }

    /**
     * Checks whether one number is prime
     * @param y - The number, which is checked whether is prime or not
     * @return
     */
    public static boolean isPrimetive(int y){
        for(int x = 2; x < y; x++){
            if(y % x == 0){
                return false;
            }
        }
        return true;
    }

}
