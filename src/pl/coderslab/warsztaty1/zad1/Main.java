package pl.coderslab.warsztaty1.zad1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int randomNumber = rand.nextInt(101);
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Zgadnij liczbę: ");
            try {
                int guessNumber = Integer.parseInt(scan.next());
                if (guessNumber < randomNumber) {
                    System.out.println("Za mało!");
                } else if (guessNumber > randomNumber) {
                    System.out.println("Za dużo!");
                } else {
                    System.out.println("Zgadłeś!");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("To nie jest liczba");
            }
        }
    }
}
